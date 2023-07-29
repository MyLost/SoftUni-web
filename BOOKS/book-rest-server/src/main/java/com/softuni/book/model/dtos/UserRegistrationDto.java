package com.softuni.book.model.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class UserRegistrationDto {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
