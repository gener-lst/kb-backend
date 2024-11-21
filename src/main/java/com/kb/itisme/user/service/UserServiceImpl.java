package com.kb.itisme.user.service;

import com.kb.itisme.user.DTO.UserDTO;
import com.kb.itisme.user.domain.User;
import com.kb.itisme.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDTO register() {
        if(userRepository.findByUserId("user01").isPresent()) throw new IllegalArgumentException("중복된 회원가입 요청입니다.");
        if(userRepository.findByUserId("user02").isPresent()) throw new IllegalArgumentException("중복된 회원가입 요청입니다.");
        User user1 = new User(null, "user01", "Password1!", "김민철");
        User user2 = new User(null, "user02", "Password1!", "김종수");
        UserDTO newUser = UserDTO.ofDTO(userRepository.save(user1));
        userRepository.save(user2);
        return newUser;
    }

    @Override
    public UserDTO login() {
        return userRepository.findByUserId("user01")
                .map(UserDTO::ofDTO)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
    }
}
