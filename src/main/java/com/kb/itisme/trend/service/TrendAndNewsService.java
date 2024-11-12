package com.kb.itisme.trend.service;

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
import java.util.List;

@Service
public class TrendAndNewsService {

    @Value("${naver.client-id}")
    private String clientId;

    @Value("${naver.client-secret}")
    private String clientSecret;

    private static final String TREND_API_URL = "https://openapi.naver.com/v1/datalab/search";
    private static final String NEWS_API_URL = "https://openapi.naver.com/v1/search/news.json";

    // 1. 네이버 트렌드 API에서 최근 1주일간 최고 검색어 가져오기
    public String getTopTrendingKeyword() throws Exception {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(7);

        String requestBody = String.format("{ \"startDate\": \"%s\", \"endDate\": \"%s\", \"timeUnit\": \"date\", " +
                        "\"keywordGroups\": [{ \"groupName\": \"트렌드\", \"keywords\": [\"인기 검색어\"] }]}",
                startDate, endDate);

        HttpURLConnection con = createConnection(TREND_API_URL, requestBody);
        String response = getResponse(con);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response).path("results");

        // 최고 트렌드 검색어 추출 (임시로 첫 번째 검색어를 가져옴)
        return root.get(0).path("title").asText();
    }

    // 2. 뉴스 API에서 최고 검색어와 관련된 뉴스 가져오기
    public List<String> getRelatedNews(String keyword) throws Exception {
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
                throw new RuntimeException("API 요청 오류: " + responseCode + " - " + errorResponse.toString());
            }
        }
    }

}

