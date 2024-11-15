package com.kb.itisme.challenge.service;

import com.kb.itisme.challenge.domain.ChallengeCommunity;
import com.kb.itisme.challenge.repo.ChallengeCommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ChallengeCommunityService {
    private final ChallengeCommunityRepository challengeCommunityRepository;

    public List<ChallengeCommunity> getAll() {
        return challengeCommunityRepository.findAll();
    }
    public ChallengeCommunity getById(Long id) {
        return challengeCommunityRepository.findById(id).orElse(null);
    }
    public ChallengeCommunity create(ChallengeCommunity challengeCommunity) {
        return challengeCommunityRepository.save(challengeCommunity);
    }
    public ChallengeCommunity update(ChallengeCommunity challengeCommunity) {
        return challengeCommunityRepository.save(challengeCommunity);
    }
    public ChallengeCommunity delete(Long id) {
        ChallengeCommunity challengeCommunity = getById(id);
        challengeCommunityRepository.delete(challengeCommunity);
        return challengeCommunity;
    }
}
