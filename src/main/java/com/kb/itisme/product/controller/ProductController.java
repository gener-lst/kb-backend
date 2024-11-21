package com.kb.itisme.product.controller;

import com.kb.itisme.product.dto.Product;
import com.kb.itisme.product.service.ProductService;
import com.kb.itisme.trend.dto.KeywordGroup;
import com.kb.itisme.trend.dto.SavingsKeywordGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

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
            List<Product> groupProducts = productService.getProductsByGroup(groupKeywords, "1");

            // 키워드 기반 검색
            List<Product> keywordProducts = (keyword != null && !keyword.isBlank())
                    ? productService.getProductsByKeyword(keyword, "1")
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


    @GetMapping("/matchingSavings")
    public ResponseEntity<?> getSavingMatchingProducts(
            @RequestParam("group") String group,
            @RequestParam(value = "keyword", required = false) String keyword) {  // Added productType parameter

        try {
            // 그룹과 관련된 키워드 검색
            SavingsKeywordGroup keywordGroup = Arrays.stream(SavingsKeywordGroup.values())
                    .filter(k -> k.getGroupName().equals(group.trim()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Invalid group name: " + group));

            List<String> groupKeywords = keywordGroup.getKeywords();

            // 그룹 기반 검색
            List<Product> groupProducts = productService.getProductsByGroup(groupKeywords, "2"); // Pass productType

            // 키워드 기반 검색
            List<Product> keywordProducts = (keyword != null && !keyword.isBlank())
                    ? productService.getProductsByKeyword(keyword, "2"
            )
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

    @PostMapping("/fetchProduct")
    public ResponseEntity<?> fetchProducts(){
        productService.startCrawling();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/searchProducts")
    public ResponseEntity<?> searchProducts(@RequestParam String query) {
        if (query == null || query.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("검색어를 입력해주세요.");
        }

        List<Product> products = productService.searchProducts(query);
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(products);
    }

}
