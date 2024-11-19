package com.kb.itisme.customPage.service;

import com.kb.itisme.customPage.dto.CustomCommunityDTO;
import com.kb.itisme.customPage.dto.CustomPageDTO;

import java.util.List;

public interface CustomPageService {
    CustomPageDTO getCustomPage(Long userNum);
    List<CustomCommunityDTO> getCustomPages();
    CustomPageDTO saveCustomPage(CustomPageDTO customPageDTO);
    void deleteCustomPage(Long userNum);
    void addHeart(Long pageID);
}
