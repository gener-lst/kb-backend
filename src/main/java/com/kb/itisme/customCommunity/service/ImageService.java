package com.kb.itisme.customCommunity.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class ImageService {

    @Value("${image.directory}")
    private String imageDirectory;

    public String saveCapturedImage(Long sharedID, String base64Image, Long userNum) throws IOException {
        // Base64 문자열에서 데이터 추출
        String base64Data = base64Image.split(",")[1];
        byte[] imageBytes = Base64.getDecoder().decode(base64Data);

        // 이미지 파일 이름 생성 (예: userNum_pageID_timestamp.png)
        String fileName = "user" + userNum + "_page" + sharedID + "_" + System.currentTimeMillis() + ".jpeg";

        // 저장할 파일 경로
        String filePath = imageDirectory + File.separator + fileName;

        // 이미지 파일 저장
        createDirectoryIfNotExists(imageDirectory);
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(imageBytes);
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException("이미지 저장 실패: " + e.getMessage());
        }
    }

    private void createDirectoryIfNotExists(String directoryPath) throws IOException {
        Path path = Paths.get(directoryPath);
        if (Files.notExists(path)) {
            Files.createDirectories(path);
            System.out.println("디렉토리를 생성했습니다: " + directoryPath);
        }
    }
}
