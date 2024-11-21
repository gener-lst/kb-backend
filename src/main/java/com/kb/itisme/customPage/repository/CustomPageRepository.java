package com.kb.itisme.customPage.repository;

import com.kb.itisme.customPage.domain.CustomPage;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CustomPageRepository extends JpaRepository<CustomPage, Long> {
    CustomPage findByUserNum(Long userNum);
    void deleteByUserNum(Long userNum);

    @Modifying
    @Transactional
    @Query("UPDATE CustomPage c SET c.imagePath = :newImagePath WHERE c.userNum = :userNum")
    int updateImagePathByUserNum(String newImagePath, Long userNum);
}
