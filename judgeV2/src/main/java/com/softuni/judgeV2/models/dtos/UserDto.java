package com.softuni.judgeV2.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;
    private String username;
    private  String password;
    private String email;
    private String git;
    private RoleDto role;
}
