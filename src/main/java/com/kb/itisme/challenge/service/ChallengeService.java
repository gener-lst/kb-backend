package com.kb.itisme.challenge.service;

import com.kb.itisme.challenge.domain.Challenge;
import com.kb.itisme.challenge.repo.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ChallengeService {
    private final ChallengeRepository challengeRepository;

    public Long saveChallenge(Challenge challenge){
        challengeRepository.save(challenge);

        return challenge.getCno();
    }

    public List<Challenge> findAllChallenges() {
    return challengeRepository.findAll();
    }

    public Optional<Challenge> findChallengeById(Long id){
        return challengeRepository.findById(id);
    }

    public Challenge updateChallenge(Challenge challenge) {
        if (challenge.getOneDayExpense() <= 10000) {
            challenge.setDayStatus(true);
        } else {
            challenge.setDayStatus(false);
        }
        return challengeRepository.save(challenge);
    }

    public Challenge updateMonthlyChallenge(Challenge challenge) {
        if(challenge.getMonthlyExpense() <= challenge.getEndPrice()) {
            challenge.setMonthlyStatus(true);

        }else{
            challenge.setMonthlyStatus(false);
        }
        return challengeRepository.save(challenge);
    }



}
