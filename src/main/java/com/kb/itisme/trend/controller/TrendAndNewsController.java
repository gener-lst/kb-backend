package com.kb.itisme.trend.controller;

import com.kb.itisme.trend.service.TrendAndNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TrendAndNewsController {

    private final TrendAndNewsService trendAndNewsService;

    @Autowired
    public TrendAndNewsController(TrendAndNewsService trendAndNewsService) {
        this.trendAndNewsService = trendAndNewsService;
    }

    @GetMapping("/top-trend-news")
    public Map<String, Object> getTopTrendNews() throws Exception {
        Map<String, Object> response = new HashMap<>();

        try {
            // Map<String, String> 형식으로 주제어와 키워드 반환
            Map<String, String> topKeywordsWithGroup = trendAndNewsService.getTopTrendingKeywords();
            System.out.println("Top Keywords with Groups: " + topKeywordsWithGroup); // 로그 추가
            if (topKeywordsWithGroup.isEmpty()) {
                response.put("success", false);
                response.put("message", "최근 1주일 동안 ratio가 100인 검색어가 없습니다.");
                return response;
            }

            // 첫 번째 키워드를 기준으로 관련 뉴스 검색
            String firstKeyword = topKeywordsWithGroup.values().iterator().next();
            List<String> newsList = trendAndNewsService.getRelatedNews(firstKeyword);
            System.out.println("News List: " + newsList); // 로그 추가

            response.put("success", true);
            response.put("keywords", topKeywordsWithGroup); // Map<String, String> 형식으로 주제어와 키워드 전달
            response.put("news", newsList);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "데이터를 가져오는 중 오류가 발생했습니다.");
            response.put("error", e.getMessage());
            System.out.println("Error: " + e.getMessage()); // 로그 추가
        }

        return response;
    }

}
