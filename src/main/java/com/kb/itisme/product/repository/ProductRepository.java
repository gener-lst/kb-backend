package com.kb.itisme.product.repository;

import com.kb.itisme.product.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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

    // benefit에 특정 키워드가 포함된 상품 검색
    @Query("SELECT p FROM Product p WHERE LOWER(p.benefit) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> findByBenefitContainingKeyword(@Param("keyword") String keyword);

    // benefit에 특정 키워드가 포함된 상품 검색 (SQL 기본 검색)
    List<Product> findByBenefitContainingIgnoreCase(String keyword);
}
