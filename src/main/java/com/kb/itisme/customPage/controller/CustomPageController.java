package com.kb.itisme.customPage.controller;

import com.kb.itisme.customPage.dto.CustomPageDTO;
import com.kb.itisme.customPage.service.CustomPageService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/custom")
@RequiredArgsConstructor
@Slf4j
public class CustomPageController {
    private final CustomPageService customPageService;

    @GetMapping("/page")
    public ResponseEntity<CustomPageDTO> getCustomPage(HttpServletRequest request, @Valid @RequestParam Long userNum) {
        return ResponseEntity.ok(customPageService.getCustomPage(userNum));
    }

    @PostMapping("/page")
    public ResponseEntity<CustomPageDTO> saveCustomPage(HttpServletRequest request, @Valid @RequestBody CustomPageDTO customPageDTO) {
        return ResponseEntity.ok(customPageService.saveCustomPage(customPageDTO));
    }

    @DeleteMapping("/page")
    public ResponseEntity<Void> resetCustomPage(HttpServletRequest request, @Valid @RequestParam Long userNum) {
        customPageService.deleteCustomPage(userNum);
        return ResponseEntity.noContent().build();
    }
    

    @PostMapping("/fileUpload")
    public ResponseEntity<Void> fileUpload(@RequestParam String fileName, @RequestParam Long userNum){
        customPageService.updateImagePath(fileName, userNum);
        return ResponseEntity.noContent().build();
    }
}
