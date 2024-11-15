package com.kb.itisme.product.controller;

import com.kb.itisme.product.dto.Product;
import com.kb.itisme.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/addProduct")
    public String addProduct(@RequestParam String cooperationcode) {
        // 새로운 Product 객체 생성
        Product product = new Product();
        product.setProductId(1L); // product_id는 자동 증가되므로 설정하지 않아도 됩니다.
        product.setProductType("1"); // product_type을 1로 설정
        product.setProductName("Sample Product"); // 예시 값, 필요에 따라 변경
        product.setImagePath("https://example.com/image.jpg"); // 예시 값, 필요에 따라 변경
        product.setProductUrl("https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0076?mainCC=a&cooperationcode=" + cooperationcode); // URL에 cooperationcode 추가

        // 데이터베이스에 저장
        productRepository.save(product);

        return "Product added with productType: " + product.getProductType();
    }
}
