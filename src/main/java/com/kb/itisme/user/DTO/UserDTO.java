package com.kb.itisme.user.DTO;

import com.kb.itisme.user.domain.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private Long userNum;
    private String userId;
    private String userPassword;
    private String userName;

    public static UserDTO ofDTO(User user) {
        return user == null ? null : UserDTO.builder()
                .userNum(user.getUserNum())
                .userId(user.getUserId())
                .userPassword(user.getUserPassword())
                .userName(user.getUserName())
                .build();
    }

    public static User toEntity(UserDTO userDTO) {
        return User.builder()
                .userNum(userDTO.getUserNum())
                .userId(userDTO.getUserId())
                .userPassword(userDTO.getUserPassword())
                .userName(userDTO.getUserName())
                .build();
    }
}
