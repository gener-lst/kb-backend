package com.kb.itisme.customPage.service;

import com.kb.itisme.customPage.domain.CustomPage;
import com.kb.itisme.customPage.dto.CustomPageDTO;
import com.kb.itisme.customPage.repository.CustomPageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomPageServiceImpl implements CustomPageService {
    private final CustomPageRepository customPageRepository;

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
}
