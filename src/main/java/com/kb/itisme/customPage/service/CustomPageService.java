package com.kb.itisme.customPage.service;

import com.kb.itisme.customPage.dto.CustomPageDTO;

public interface CustomPageService {
    CustomPageDTO getCustomPage(Long userNum);
    CustomPageDTO saveCustomPage(CustomPageDTO customPageDTO);
    void deleteCustomPage(Long userNum);
}
