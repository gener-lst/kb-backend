package com.kb.itisme.customCommunity.controller;

import com.kb.itisme.customCommunity.dto.CustomCommunityDTO;
import com.kb.itisme.customCommunity.service.CustomCommunityService;
import com.kb.itisme.customPage.dto.CustomPageDTO;
import com.kb.itisme.user.DTO.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/page/download")
    public ResponseEntity<?> downloadCustomPage(HttpServletRequest request, @Valid @RequestParam Long shareID) {
        try {
            return ResponseEntity.ok(customCommunityService.downloadCustomPage(shareID));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("데이터를 불러오는 도중 문제가 발생했습니다.");
        }
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
