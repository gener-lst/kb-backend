package com.kb.itisme.product.controller;

import com.kb.itisme.product.dto.Product;
import com.kb.itisme.product.repository.ProductRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class KBCrawl {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BenefitCrawl benefitCrawl;

    @Transactional
    public void startCrawling() {
        // WebDriverManager를 사용하여 ChromeDriver 130 버전 자동 설정
        WebDriverManager.chromedriver().browserVersion("130").setup();  // Chrome 130 버전

        // 크롬 옵션 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920x1080");
        options.addArguments("--lang=ko");  // 한글로 설정
        options.addArguments("--disable-web-security"); // SameSite None 우회

        WebDriver driver = new ChromeDriver(options);

        try {
            // 페이지 URL 목록
            String[] urls = {
                    "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=1",
                    "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=7",
                    "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=5",
                    "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=2",
                    "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=3",
                    "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=10",
                    "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=8",
                    "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0047?pageNo=1&cateIdx=9"
            };

            // 각 URL에 대해 크롤링
            for (String url : urls) {
                driver.get(url);

                // 페이지 로드 대기
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.card-box__item")));

                // 카드 정보 추출
                extractCardInfo(driver);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 브라우저 종료
            driver.quit();
        }
    }

    // 카드 정보 추출 메서드
    public void extractCardInfo(WebDriver driver) {
        // 카드 리스트 추출
        List<WebElement> cardItems = driver.findElements(By.cssSelector("div.card-box__item"));

        // 카드 정보를 추출하고 출력
        for (WebElement cardItem : cardItems) {
            String cardName = cardItem.findElement(By.cssSelector("h3.tit-dep4")).getText();  // 카드 이름
            String cardDescription = cardItem.findElement(By.cssSelector("p.badge--txt.pl0")).getText();  // 카드 설명
            String cardImageUrl = cardItem.findElement(By.cssSelector("img")).getAttribute("src");  // 카드 이미지 URL
            String productUrl = "https://card.kbcard.com/CRD/DVIEW/HCAMCXPRICAC0076?mainCC=a&cooperationcode=" + cardItem.findElement(By.cssSelector("a.linkDetail")).getAttribute("onclick").split("'")[1]; // 카드 URL

            String productCode = cardItem.findElement(By.cssSelector("a.linkDetail")).getAttribute("onclick").split("'")[1];

            // 혜택 크롤링 후 benefit 설정
            String benefit = String.valueOf(benefitCrawl.benefitCrawling(productCode)); // Benefit 반환값을 받는다

            // 중복 데이터가 없으면 저장
            if (!productRepository.existsByProductUrl(productUrl)) {
                Product product = new Product();
                product.setProductType("1"); // 예시로 1 설정
                product.setProductName(cardName);
                product.setImagePath(cardImageUrl);
                product.setProductUrl(productUrl);
                product.setProductCode(productCode);
                product.setBenefit(benefit); // benefit 설정
                productRepository.save(product);

                System.out.println("Product added: " + cardName);
            } else {
                System.out.println("Product already exists: " + cardName);
            }
        }
    }
}
