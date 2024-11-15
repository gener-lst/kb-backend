package com.kb.itisme.product.controller;

import com.kb.itisme.product.dto.Product;
import com.kb.itisme.product.repository.ProductRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BenefitCrawl {

    @Autowired
    private ProductRepository productRepository;

    public StringBuilder benefitCrawling(String productCode) {
        StringBuilder benefitText = null;
        try {
            // 두 번째 URL
            String url = "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0076?mainCC=a&cooperationcode=" + productCode;

            // Jsoup으로 페이지 HTML 로드
            Document document = Jsoup.connect(url).get();

            // 혜택 정보 추출
            Elements benefitItems = document.select("ul.cardList1 > li");

            // 혜택 정보 출력 및 저장
            benefitText = new StringBuilder();
            for (Element benefitItem : benefitItems) {
                String category = benefitItem.select("p").text();  // 혜택 카테고리 (예: 국내 이용, 해외 이용)

                // 로그로 추출된 혜택 정보 출력
                benefitText.append(category).append(": ").append("\n");
            }

            // Product 객체를 찾아서 Benefit 정보 업데이트
            Product product = productRepository.findByProductCode(productCode).orElse(null);

            if (product != null) {
                product.setBenefit(benefitText.toString());  // 혜택 정보를 설정
                // 데이터베이스에 저장
                productRepository.save(product);
            } else {
                System.out.println("No product found with productCode: " + productCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return benefitText;
    }
}
