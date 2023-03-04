package com.softuni.judgeV2.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileDto {

    private String username;
    private Set<String> exercises;
    private String email;
    private String git;

}
