package com.kb.itisme.challenge.repo;

import com.kb.itisme.challenge.domain.Challenge;
import com.kb.itisme.challenge.domain.ChallengeCommunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
//    List<Challenge> findAllByChallengesIn(List<String> challenge);
//    List<Challenge> updateChallengesByChallengeStatus(Challenge challengeStatus);
}
