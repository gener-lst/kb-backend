package com.kb.itisme.trend.service;

import com.kb.itisme.trend.dto.KeywordGroup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrendAndNewsService {

    @Value("${naver.client-id}")
    private String clientId;

    @Value("${naver.client-secret}")
    private String clientSecret;

    private static final String TREND_API_URL = "https://openapi.naver.com/v1/datalab/search";
    private static final String NEWS_API_URL = "https://openapi.naver.com/v1/search/news.json";

    private HttpURLConnection createConnection(String apiUrl, String requestBody) throws Exception {
        HttpURLConnection con = (HttpURLConnection) new URL(apiUrl).openConnection();
        con.setRequestProperty("X-Naver-Client-Id", clientId);
        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

        if (requestBody != null) {
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
        } else {
            con.setRequestMethod("GET");
        }
        return con;
    }

    private String getResponse(HttpURLConnection con) throws Exception {
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }
        } else {
            // 오류 발생 시 메시지 출력
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getErrorStream(), StandardCharsets.UTF_8))) {
                StringBuilder errorResponse = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    errorResponse.append(line);
                }
                throw new RuntimeException("API 요청 오류: " + responseCode + " - " + errorResponse);
            }
        }
    }

    // 1. 네이버 트렌드 API에서 최근 1주일간 최고 검색어 가져오기
    public Map<String, String> getTopTrendingKeywords() throws Exception {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(7);

        Map<String, String> keywordsWithGroupNames = new HashMap<>();
        List<KeywordGroup> allGroups = List.of(KeywordGroup.values());

        // 5개씩 분할하여 API 요청을 보냄
        for (int i = 0; i < allGroups.size(); i += 5) {
            List<KeywordGroup> currentGroups = allGroups.subList(i, Math.min(i + 5, allGroups.size()));

            StringBuilder groupsJson = new StringBuilder();
            for (KeywordGroup group : currentGroups) {
                String keywordsJson = group.getKeywords().stream()
                        .map(keyword -> "\"" + keyword + "\"")
                        .reduce((kw1, kw2) -> kw1 + ", " + kw2)
                        .orElse("");

                groupsJson.append(String.format("{ \"groupName\": \"%s\", \"keywords\": [%s] },",
                        group.getGroupName(), keywordsJson));
            }

            if (groupsJson.length() > 0) {
                groupsJson.deleteCharAt(groupsJson.length() - 1);
            }

            String requestBody = String.format("{ \"startDate\": \"%s\", \"endDate\": \"%s\", \"timeUnit\": \"date\", " +
                    "\"keywordGroups\": [%s] }", startDate, endDate, groupsJson);

            HttpURLConnection con = createConnection(TREND_API_URL, requestBody);
            String response = getResponse(con);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response).path("results");

            for (JsonNode result : root) {
                String groupName = result.path("title").asText();
                for (JsonNode data : result.path("data")) {
                    if (data.path("ratio").asDouble() == 100.0) {
                        keywordsWithGroupNames.put(groupName, result.path("keywords").get(0).asText());
                        break;
                    }
                }
            }
        }

        if (keywordsWithGroupNames.isEmpty()) {
            throw new RuntimeException("최근 1주일 동안 ratio가 100인 검색어가 없습니다.");
        }

        return keywordsWithGroupNames;
    }

    // 2. 뉴스 API에서 최고 검색어와 관련된 뉴스 가져오기
    public List<String> getRelatedNews(String keyword) throws Exception {
        // 키워드를 UTF-8로 인코딩
        String encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8);
        String url = NEWS_API_URL + "?query=" + encodedKeyword + "&display=5&sort=date";

        HttpURLConnection con = createConnection(url, null);
        String response = getResponse(con);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode items = mapper.readTree(response).path("items");

        List<String> newsList = new ArrayList<>();
        for (JsonNode item : items) {
            newsList.add(item.path("title").asText());
        }
        return newsList;
    }

    public Map<String, Object> getTopTrendNews() throws Exception {
        Map<String, String> topKeywordsWithGroupNames = getTopTrendingKeywords(); // 트렌드 키워드와 주제어 가져오기
        Map<String, List<String>> newsMap = new HashMap<>(); // 각 키워드의 관련 뉴스 맵 생성

        // 각 키워드에 대해 뉴스 검색
        for (String keyword : topKeywordsWithGroupNames.values()) {
            List<String> relatedNews = getRelatedNews(keyword); // 키워드에 대한 뉴스 가져오기
            newsMap.put(keyword, relatedNews); // 키워드와 관련 뉴스 저장
        }

        // 최종 응답 데이터 구성
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("keywords", topKeywordsWithGroupNames); // 주제어와 키워드
        response.put("news", newsMap); // 키워드별 관련 뉴스

        return response;
    }

}

