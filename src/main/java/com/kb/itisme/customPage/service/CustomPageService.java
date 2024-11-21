package com.kb.itisme.customPage.service;

import com.kb.itisme.customPage.domain.CustomPage;
import com.kb.itisme.customPage.dto.CustomPageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CustomPageService {
    CustomPageDTO getCustomPage(Long userNum);

    CustomPageDTO saveCustomPage(CustomPageDTO customPageDTO);

    void deleteCustomPage(Long userNum);

    void updateImagePath(String fileName, Long userNum);
}
