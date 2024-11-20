package com.kb.itisme.customCommunity.service;

import com.kb.itisme.customCommunity.dto.CustomCommunityDTO;
import com.kb.itisme.customPage.dto.CustomPageDTO;

import java.util.List;

public interface CustomCommunityService {
    List<CustomCommunityDTO> getCustomPages();
    void addHeart(Long sharedID);
    void shareCustomPage(CustomPageDTO customPageDTO, String pageName);
    CustomCommunityDTO downloadCustomPage(Long shareID);
}
