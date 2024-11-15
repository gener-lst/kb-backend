package com.kb.itisme.challenge.repo;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChallengeRepositoryTest {


    @Autowired
    EntityManager em;
    @Autowired
    ChallengeRepository challengeRepository;

    @Test
    void save(){

    }
}