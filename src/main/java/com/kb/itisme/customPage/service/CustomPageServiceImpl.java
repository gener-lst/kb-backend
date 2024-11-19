package com.kb.itisme.customPage.service;

import com.kb.itisme.customPage.domain.CustomPage;
import com.kb.itisme.customPage.dto.CustomCommunityDTO;
import com.kb.itisme.customPage.dto.CustomPageDTO;
import com.kb.itisme.customPage.repository.CustomCommunityRepository;
import com.kb.itisme.customPage.repository.CustomPageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomPageServiceImpl implements CustomPageService {
    private final CustomPageRepository customPageRepository;
    private final CustomCommunityRepository customCommunityRepository;

    @Override
    public CustomPageDTO getCustomPage(Long userNum) {
        return CustomPageDTO.ofDTO(customPageRepository.findByUserNum(userNum));
    }

    @Override
    public List<CustomCommunityDTO> getCustomPages() {
        return customCommunityRepository.findALlCustomPages().stream().map(CustomCommunityDTO::ofDTO).toList();
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
    public void addHeart(Long pageID) {
        customCommunityRepository.incrementCountById(pageID);
    }
}
