package com.kb.itisme.customPage.service;

import com.kb.itisme.customCommunity.service.ImageService;
import com.kb.itisme.customPage.domain.CustomPage;
import com.kb.itisme.customPage.dto.CustomPageDTO;
import com.kb.itisme.customPage.repository.CustomPageRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomPageServiceImpl implements CustomPageService {
    private final CustomPageRepository customPageRepository;
    private final ImageService imageService;

    @Override
    public CustomPageDTO getCustomPage(Long userNum) {
        return CustomPageDTO.ofDTO(customPageRepository.findByUserNum(userNum));
    }

    @Override
    public CustomPageDTO saveCustomPage(CustomPageDTO customPageDTO) {
        CustomPage savedCustomPage = customPageRepository.save(CustomPageDTO.toEntity(customPageDTO));
        return CustomPageDTO.ofDTO(savedCustomPage);
    }

    @Override
    public void deleteCustomPage(Long userNum) {
        customPageRepository.deleteByUserNum(userNum);
    }


    @Override
    public void updateImagePath(String newImagePath, Long userNum) {
        customPageRepository.updateImagePathByUserNum(newImagePath, userNum);
    }

}
