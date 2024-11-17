package com.kb.itisme.challenge.controller;


import com.kb.itisme.challenge.domain.ChallengeCommunity;
import com.kb.itisme.challenge.service.ChallengeCommunityService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/challengeCommunity")
@RequiredArgsConstructor
public class ChallengeCommunityController {
    private final ChallengeCommunityService challengeCommunityService;
    @GetMapping("/pages")
    public ResponseEntity<List<ChallengeCommunity>> getAll(HttpServletRequest request){
    HttpSession session=request.getSession();
    return ResponseEntity.ok(challengeCommunityService.getAll());

    }

//    @PostMapping("/pages")
//    public ResponseEntity<ChallengeCommunity> create(HttpServletRequest request){
//        HttpSession session=request.getSession();
//        Long ChallengeCommunityId = (Long)session.getAttribute("challengeCommunityId");
//
//        return ResponseEntity.ok(challengeCommunityService.create(c));
//    }


}
