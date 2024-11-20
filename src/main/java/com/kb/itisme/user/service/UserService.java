package com.kb.itisme.user.service;

import com.kb.itisme.user.DTO.UserDTO;

public interface UserService {
    UserDTO register();
    UserDTO login();
    UserDTO getUserInfo(Long userNum);
}
