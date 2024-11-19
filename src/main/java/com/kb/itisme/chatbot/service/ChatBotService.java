package com.kb.itisme.chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ChatBotService {

    @Autowired
    private YoutubeService youtubeService;

    public String getAnswer(String question) {
        try {
            // 질문을 유튜브 검색어로 사용하여 검색 수행
            String searchResult = youtubeService.searchVideo(question);
            return searchResult;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while processing the question: " + e.getMessage();
        }
    }
}