package com.kb.itisme.product.service;

import com.kb.itisme.product.dto.Product;
import com.kb.itisme.product.repository.ProductRepository;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // 그룹 키워드에 기반한 상품 검색
    public List<Product> getProductsByGroup(List<String> keywords, String productType) {
        List<Product> matchingProducts = new ArrayList<>();
        for (String keyword : keywords) {
            // Spring Data JPA 기본 메서드 사용
            List<Product> products = productRepository.findByBenefitContainingIgnoreCaseAndProductType(keyword, productType);
            matchingProducts.addAll(products);
        }
        return matchingProducts;
    }

    // 특정 키워드가 포함된 상품 검색
    public List<Product> getProductsByKeyword(String keyword, String productType) {
        return productRepository.findByBenefitContainingIgnoreCaseAndProductType(keyword, productType);
    }

    @Transactional
    public void startCrawling() {
        WebDriverManager.chromedriver().browserVersion("130").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--lang=ko");

        WebDriver driver = null;
        try {
            driver = new ChromeDriver(options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            String[] urls = getUrls();

            for (String url : urls) {
                try {
                    driver.manage().deleteAllCookies();
                    driver.get(url);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.card-box__item")));
                    extractCardInfo(driver);
                } catch (Exception e) {
                    System.err.println("Error processing URL: " + url + " -> " + e.getMessage());
                }
            }
        }  catch (Exception e) {
            System.err.println("Error initializing WebDriver: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private String[] getUrls() {
        return new String[]{
                "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=1",
                "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=7",
                "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=5",
                "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=2",
                "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=3",
                "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=10",
                "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=8",
                "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=9"
        };
    }

    private void extractCardInfo(WebDriver driver) {
        List<WebElement> cardItems = driver.findElements(By.cssSelector("div.card-box__item"));

        for (WebElement cardItem : cardItems) {
            try {
                // 카드 이름
                String cardName = cardItem.findElement(By.cssSelector("h3.tit-dep4")).getText();

                // 제품 코드
                String productCode = cardItem.findElement(By.cssSelector("a.linkDetail"))
                        .getAttribute("onclick").split("'")[1];

                // 제품 URL
                String productUrl = "https://m.kbcard.com/CRD/DVIEW/MCAMCXHIACRC0002?mainCC=a&cooperationcode=" + productCode;

                // 이미지 URL
                String imagePath = cardItem.findElement(By.cssSelector("img")).getAttribute("src");

                // 데이터베이스에 존재 여부 확인
                if (productRepository.existsByProductCode(productCode)) {
                    continue; // 크롤링 건너뛰기
                }

                // 새 데이터 저장 로직
                Product product = new Product();
                product.setProductName(cardName);
                product.setProductType("1");
                product.setProductCode(productCode);
                product.setProductUrl(productUrl);
                product.setImagePath(imagePath); // 이미지 URL 추가
                product.setBenefit(benefitCrawling(productCode).toString());

                saveProduct(product);
            } catch (Exception e) {
                System.err.println("Error processing card item: " + e.getMessage());
            }
        }
    }


    @Transactional
    public void saveProduct(Product product) {
        try {
            if (!productRepository.existsByProductCode(product.getProductCode())) {
                productRepository.save(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
                benefitText.append(category).append(", ").append("\n");
            }

            // Product 객체를 찾아서 Benefit 정보 업데이트
            Product product = productRepository.findByProductCode(productCode).orElse(null);

            if (product != null) {
                product.setBenefit(benefitText.toString());  // 혜택 정보를 설정
                // 데이터베이스에 저장
                productRepository.save(product);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return benefitText;
    }
}
