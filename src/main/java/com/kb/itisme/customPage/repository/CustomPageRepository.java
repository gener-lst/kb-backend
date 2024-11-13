package com.kb.itisme.customPage.repository;

import com.kb.itisme.customPage.domain.CustomPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomPageRepository extends JpaRepository<CustomPage, Long> {
    CustomPage findByUserNum(Long userNum);
    void deleteByUserNum(Long userNum);
}
