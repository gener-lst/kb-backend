package com.kb.itisme;

import com.kb.itisme.product.controller.BenefitCrawl;
import com.kb.itisme.product.controller.KBCrawl;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class KbBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KbBackendApplication.class, args);
	}

	// 애플리케이션이 시작될 때 자동으로 크롤링을 실행하도록 설정
	@Autowired
	private KBCrawl kbCrawl;

	@Autowired
	private BenefitCrawl benefitCrawl;

	@PostConstruct
	public void init() {
		// 애플리케이션이 시작될 때 크롤링 시작
		kbCrawl.startCrawling();

	}
}
