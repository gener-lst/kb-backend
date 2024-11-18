package com.kb.itisme.chatbot.controller;

import com.kb.itisme.chatbot.service.ChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chatbot")
public class ChatBotController {

    @Autowired
    private ChatBotService chatBotService;

    @GetMapping
    public String chatbotPage() {
        return "chatbot";  // 필요 시 수정
    }

    @PostMapping("/ask")
    public String askChatbot(@RequestParam String question) {
        return chatBotService.getAnswer(question);
    }
}
