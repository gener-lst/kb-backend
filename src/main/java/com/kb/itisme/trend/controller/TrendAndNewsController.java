package com.kb.itisme.trend.controller;

import com.kb.itisme.trend.service.TrendAndNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrendAndNewsController {

    private final TrendAndNewsService trendAndNewsService;

    @Autowired
    public TrendAndNewsController(TrendAndNewsService trendAndNewsService) {
        this.trendAndNewsService = trendAndNewsService;
    }

    @GetMapping("/top-trend-news")
    public List<String> getTopTrendNews() throws Exception {
        String topKeyword = trendAndNewsService.getTopTrendingKeyword();
        return trendAndNewsService.getRelatedNews(topKeyword);
    }
}
