package com.kb.itisme.product.controller;

import com.kb.itisme.product.dto.Product;
import com.kb.itisme.product.service.ProductService;
import com.kb.itisme.trend.dto.KeywordGroup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/matchingProducts")
    public ResponseEntity<?> getMatchingProducts(
            @RequestParam("group") String group,
            @RequestParam(value = "keyword", required = false) String keyword) {

        try {
            // 그룹과 관련된 키워드 검색
            KeywordGroup keywordGroup = Arrays.stream(KeywordGroup.values())
                    .filter(k -> k.getGroupName().equals(group.trim()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Invalid group name: " + group));

            List<String> groupKeywords = keywordGroup.getKeywords();

            // 그룹 기반 검색
            List<Product> groupProducts = productService.getProductsByGroup(groupKeywords);

            // 키워드 기반 검색
            List<Product> keywordProducts = (keyword != null && !keyword.isBlank())
                    ? productService.getProductsByKeyword(keyword)
                    : Collections.emptyList();

            // 응답 구성
            Map<String, Object> response = new HashMap<>();
            response.put("groupProducts", groupProducts);
            response.put("keywordProducts", keywordProducts);

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Internal server error"));
        }
    }

}
