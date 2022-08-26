package com.thn.restpetstore.dto;

import com.thn.restpetstore.entity.UserStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private UserStatus userStatus;
}
