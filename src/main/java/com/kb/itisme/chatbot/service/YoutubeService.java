package com.kb.itisme.chatbot.service;

import java.util.Comparator;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Value;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import org.apache.commons.text.similarity.JaccardSimilarity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class YoutubeService {

    @Value("${youtube.api.key}")
    private String apiKey;

    public String searchVideo(String query) throws IOException {
        // JSON 데이터를 처리하기 위한 JsonFactory 객체 생성
        JsonFactory jsonFactory = new JacksonFactory();

        // YouTube 객체를 빌드하여 API에 접근할 수 있는 YouTube 클라이언트 생성
        YouTube youtube = new YouTube.Builder(
                new com.google.api.client.http.javanet.NetHttpTransport(),
                jsonFactory,
                request -> {})
                .build();

        // 특정 플레이리스트 ID
        String playlistId = "PLVk9yUyh7ZtpNFLZxIDdcnxm3jVrvd6iR";

        // YouTube PlaylistItems API를 사용하여 플레이리스트의 동영상 가져오기
        YouTube.PlaylistItems.List playlistItemsRequest = youtube.playlistItems().list(Collections.singletonList("snippet"));
        playlistItemsRequest.setKey(apiKey);
        playlistItemsRequest.setPlaylistId(playlistId);
        playlistItemsRequest.setMaxResults(50L); // 최대 50개 동영상 가져오기

        PlaylistItemListResponse playlistResponse = playlistItemsRequest.execute();
        List<PlaylistItem> playlistItems = playlistResponse.getItems();

        if (playlistItems == null || playlistItems.isEmpty()) {
            return "플레이리스트에 동영상이 없습니다.";
        }

        // 질문(query)과 가장 유사한 제목을 가진 동영상 찾기
        PlaylistItem bestMatch = playlistItems.stream()
                .peek(item -> {
                    double sim = similarity(item.getSnippet().getTitle(), query);
                    System.out.println("Title: " + item.getSnippet().getTitle() + ", Similarity: " + sim);
                })
                .max(Comparator.comparingDouble(item -> similarity(item.getSnippet().getTitle(), query)))
                .orElse(null);

        if (bestMatch != null) {
            String videoId = bestMatch.getSnippet().getResourceId().getVideoId();
            String videoTitle = bestMatch.getSnippet().getTitle();
            return "Title: " + videoTitle + "\nURL: https://www.youtube.com/watch?v=" + videoId;
        }
        return "질문과 유사한 동영상을 찾을 수 없습니다.";
    }

    // 문자열 유사도 계산
    private double similarity(String str1, String str2) {
        JaccardSimilarity jaccard = new JaccardSimilarity();
        return jaccard.apply(str1.toLowerCase(), str2.toLowerCase());
    }
}

