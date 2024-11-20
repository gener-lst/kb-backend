package com.kb.itisme.customCommunity.service;

import com.kb.itisme.customCommunity.domain.CustomCommunity;
import com.kb.itisme.customCommunity.dto.CustomCommunityDTO;
import com.kb.itisme.customCommunity.repository.CustomCommunityRepository;
import com.kb.itisme.customPage.domain.CustomPage;
import com.kb.itisme.customPage.dto.CustomPageDTO;
import com.kb.itisme.customPage.repository.CustomPageRepository;
import com.kb.itisme.customPage.service.CustomPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomCommunityServiceImpl implements CustomCommunityService {
    private final CustomCommunityRepository customCommunityRepository;

    @Override
    public List<CustomCommunityDTO> getCustomPages() {
        return customCommunityRepository.findAll().stream().map(CustomCommunityDTO::ofDTO).toList();
    }

    @Override
    public void addHeart(Long sharedID) {
        customCommunityRepository.incrementCountById(sharedID);
    }

    @Override
    public void shareCustomPage(CustomPageDTO customPageDTO, String pageName) {
        if(customCommunityRepository.findById(customPageDTO.getUserNum()).isPresent()) throw new IllegalArgumentException("이미 공유된 페이지입니다.");

        CustomCommunityDTO customCommunityDTO = new CustomCommunityDTO();
        customCommunityDTO.setUserNum(customPageDTO.getUserNum());
        customCommunityDTO.setPageName(pageName);
        customCommunityDTO.setLayoutData(customPageDTO.getLayoutData());
        customCommunityDTO.setImagePath(customPageDTO.getImagePath());
        customCommunityDTO.setHeart(0L);

        CustomCommunity sharedPage = CustomCommunityDTO.toEntity(customCommunityDTO);

        customCommunityRepository.save(sharedPage);
    }

    @Override
    public CustomPageDTO downloadCustomPage(Long shareID) {
       CustomCommunityDTO customCommunityDTO = customCommunityRepository.findById(shareID)
                .map(entity -> CustomCommunityDTO.ofDTO(entity)) // 엔티티를 DTO로 변환
                .orElseThrow(() -> new IllegalArgumentException("해당 페이지를 불러올 수 없습니다."));

       CustomPageDTO customPageDTO = new CustomPageDTO();

       customPageDTO.setLayoutData(customCommunityDTO.getLayoutData());
       customPageDTO.setImagePath(customCommunityDTO.getImagePath());

       return customPageDTO;
    }
}
