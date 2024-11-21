package com.kb.itisme.trend.controller;

import com.kb.itisme.product.dto.Product;
import com.kb.itisme.trend.service.SavingTrendService;
import com.kb.itisme.trend.service.TrendAndNewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TrendAndNewsController {

    private static final Logger logger = LoggerFactory.getLogger(TrendAndNewsController.class);
    private final TrendAndNewsService trendAndNewsService;
    private final SavingTrendService savingTrendService;

    @Autowired
    public TrendAndNewsController(TrendAndNewsService trendAndNewsService, SavingTrendService savingTrendService) {
        this.trendAndNewsService = trendAndNewsService;
        this.savingTrendService = savingTrendService;
    }

    @GetMapping("/top-trend-news")
    public Map<String, Object> getTopTrendNews() {
        Map<String, Object> response = new HashMap<>();

        try {
            // 트렌드 키워드와 주제어 가져오기
            Map<String, String> topKeywordsWithGroup = trendAndNewsService.getTopTrendingKeywords();
            logger.info("Top Keywords with Groups: {}", topKeywordsWithGroup);

            if (topKeywordsWithGroup.isEmpty()) {
                response.put("success", false);
                response.put("message", "최근 1주일 동안 트렌드 키워드를 찾을 수 없습니다.");
                return response;
            }

            // 각 키워드별 뉴스 가져오기
            Map<String, List<String>> newsMap = new HashMap<>();
            for (String keyword : topKeywordsWithGroup.values()) {
                List<String> newsList = trendAndNewsService.getRelatedNews(keyword);
                logger.info("News for keyword [{}]: {}", keyword, newsList);
                newsMap.put(keyword, newsList);
            }

            // 응답 데이터 구성
            response.put("success", true);
            response.put("keywords", topKeywordsWithGroup); // Map<String, String> 형식으로 주제어와 키워드
            response.put("news", newsMap); // Map<String, List<String>> 형식으로 키워드별 뉴스

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "데이터를 가져오는 중 오류가 발생했습니다.");
            response.put("error", e.getMessage());
            logger.error("Error occurred while fetching trend and news data: {}", e.getMessage(), e);
        }

        return response;
    }

    @GetMapping("/top-savings-news")
    public Map<String, Object> getTopTrendSavingNews() {
        Map<String, Object> response = new HashMap<>();

        try {
            // 트렌드 키워드와 주제어 가져오기
            Map<String, String> topKeywordsWithGroup = savingTrendService.getTopTrendingKeywords();
            logger.info("Top Keywords with Groups: {}", topKeywordsWithGroup);

            if (topKeywordsWithGroup.isEmpty()) {
                response.put("success", false);
                response.put("message", "최근 1주일 동안 트렌드 키워드를 찾을 수 없습니다.");
                return response;
            }

            // 각 키워드별 뉴스 가져오기
            Map<String, List<String>> newsMap = new HashMap<>();
            for (String keyword : topKeywordsWithGroup.values()) {
                List<String> newsList = savingTrendService.getRelatedNews(keyword);
                logger.info("News for keyword [{}]: {}", keyword, newsList);
                newsMap.put(keyword, newsList);
            }

            // 응답 데이터 구성
            response.put("success", true);
            response.put("keywords", topKeywordsWithGroup); // Map<String, String> 형식으로 주제어와 키워드
            response.put("news", newsMap); // Map<String, List<String>> 형식으로 키워드별 뉴스

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "데이터를 가져오는 중 오류가 발생했습니다.");
            response.put("error", e.getMessage());
            logger.error("Error occurred while fetching trend and news data: {}", e.getMessage(), e);
        }

        return response;
    }



}


