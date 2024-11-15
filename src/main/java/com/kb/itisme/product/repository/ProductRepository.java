package com.kb.itisme.product.repository;

import com.kb.itisme.product.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Product URL로 중복 체크
    boolean existsByProductUrl(String productUrl);

    // Product Name으로 중복 체크
    boolean existsByProductName(String productName);

    // Product Code로 중복 체크
    boolean existsByProductCode(String productCode);

    // Product Code로 조회 (optional로 반환)
    Optional<Product> findByProductCode(String productCode);

    // Product URL로 조회
    Optional<Product> findByProductUrl(String productUrl);
}
