package com.kb.itisme.challenge.repo;

import com.kb.itisme.challenge.domain.ChallengeCommunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ChallengeCommunityRepository extends JpaRepository<ChallengeCommunity, Long> {
}
