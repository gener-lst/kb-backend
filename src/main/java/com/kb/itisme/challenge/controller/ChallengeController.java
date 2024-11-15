package com.kb.itisme.challenge.controller;

import com.kb.itisme.challenge.domain.Challenge;
import com.kb.itisme.challenge.service.ChallengeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/challenge")
@Slf4j
public class ChallengeController {
    private final ChallengeService challengeService;
    @GetMapping("/page")
    public ResponseEntity<List<Challenge>> findAllChallenges(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long challengeId = (Long) session.getAttribute("challengeId");
        log.info("challengeId = {}", challengeId);

        return ResponseEntity.ok(challengeService.findAllChallenges());
    }

}
