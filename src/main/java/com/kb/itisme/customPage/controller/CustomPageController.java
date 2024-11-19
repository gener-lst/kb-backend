package com.kb.itisme.customPage.controller;

import com.kb.itisme.customPage.dto.CustomPageDTO;
import com.kb.itisme.customPage.service.CustomPageService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/custom")
@RequiredArgsConstructor
@Slf4j
public class CustomPageController {
    private final CustomPageService customPageService;

    @GetMapping("/page")
    public ResponseEntity<CustomPageDTO> getCustomPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userNum = (Long) session.getAttribute("userNum");
        return ResponseEntity.ok(customPageService.getCustomPage(userNum));
    }

    @PostMapping("/page")
    public ResponseEntity<CustomPageDTO> saveCustomPage(HttpServletRequest request, @Valid @RequestBody CustomPageDTO customPageDTO) {
        return ResponseEntity.ok(customPageService.saveCustomPage(customPageDTO));
    }

    @DeleteMapping("/page")
    public ResponseEntity<Void> resetCustomPage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userNum = (Long) session.getAttribute("userNum");
        customPageService.deleteCustomPage(userNum);
        return ResponseEntity.noContent().build();
    }
}
