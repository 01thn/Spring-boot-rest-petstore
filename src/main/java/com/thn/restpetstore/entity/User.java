package com.thn.restpetstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private int userStatus;
}
