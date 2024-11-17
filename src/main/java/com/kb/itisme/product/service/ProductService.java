package com.kb.itisme.product.service;

import com.kb.itisme.product.dto.Product;
import com.kb.itisme.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 그룹 키워드에 기반한 상품 검색
    public List<Product> getProductsByGroup(List<String> keywords) {
        List<Product> matchingProducts = new ArrayList<>();
        for (String keyword : keywords) {
            // Spring Data JPA 기본 메서드 사용
            List<Product> products = productRepository.findByBenefitContainingIgnoreCase(keyword);
            matchingProducts.addAll(products);
        }
        return matchingProducts;
    }

    // 특정 키워드가 포함된 상품 검색
    public List<Product> getProductsByKeyword(String keyword) {
        return productRepository.findByBenefitContainingIgnoreCase(keyword);
    }
}
