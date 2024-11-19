package com.kb.itisme.customCommunity.controller;

import com.kb.itisme.customCommunity.dto.CustomCommunityDTO;
import com.kb.itisme.customCommunity.service.CustomCommunityService;
import com.kb.itisme.customPage.dto.CustomPageDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
@Slf4j
public class CustomCommunityController {
    private final CustomCommunityService customCommunityService;

    @GetMapping("/pages")
    public ResponseEntity<List<CustomCommunityDTO>> getCustomPages(HttpServletRequest request) {
        return ResponseEntity.ok(customCommunityService.getCustomPages());
    }

    @PostMapping("/pages/share")
    public ResponseEntity<Void> shareCustomPage(HttpServletRequest request, @Valid @RequestBody CustomPageDTO customPageDTO, @Valid @RequestParam String pageName) {
        customCommunityService.shareCustomPage(customPageDTO, pageName);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/pages/heart")
    public ResponseEntity<Void> heartCustomPage(HttpServletRequest request, @Valid @RequestParam Long sharedID) {
        customCommunityService.addHeart(sharedID);
        return ResponseEntity.noContent().build();
    }
}
