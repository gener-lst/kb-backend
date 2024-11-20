package com.kb.itisme;

import com.kb.itisme.user.controller.UserController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KbBackendApplication implements CommandLineRunner {

	private final UserController userController;

	public KbBackendApplication(UserController userController) {
		this.userController = userController;
	}

	public static void main(String[] args) {
		SpringApplication.run(KbBackendApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			// 회원가입 호출
			userController.register();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
