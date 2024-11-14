package com.kb.itisme.user.service;

import com.kb.itisme.user.DTO.UserDTO;
import com.kb.itisme.user.domain.User;
import com.kb.itisme.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDTO register() {
        User newUser = new User(null, "user01", "Password1!", "김민철");
        return UserDTO.ofDTO(userRepository.save(newUser));
    }

    @Override
    public UserDTO login() {
        return UserDTO.ofDTO(userRepository.findById(1L).get());
    }
}
