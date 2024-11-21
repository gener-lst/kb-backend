package com.kb.itisme.customCommunity.repository;

import com.kb.itisme.customCommunity.domain.CustomCommunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomCommunityRepository extends JpaRepository<CustomCommunity, Long> {
    // 특정 ID의 'count' 컬럼을 1 증가시키는 쿼리
    @Modifying
    @Transactional
    @Query("UPDATE CustomCommunity SET heart = heart + 1 WHERE sharedID = :id")
    int incrementCountById(Long id); // 업데이트된 행의 개수를 반환
}
