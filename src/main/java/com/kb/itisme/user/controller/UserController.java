package com.kb.itisme.user.controller;

import com.kb.itisme.user.DTO.UserDTO;
import com.kb.itisme.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register() {
        return ResponseEntity.ok(userService.register());
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDTO user = userService.login();
        session.setAttribute("user", user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return ResponseEntity.noContent().build();
    }
}
