package com.resellerapp.model.bindings.users;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.jetbrains.annotations.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterBindingModel {

    @Length(min=2, message="Username length must be between 3 and 20 characters!")
    private String username;

    @Email
    private String email;

    @Length(min=3, message="Username length must be between 3 and 20 characters!")
    private String password;
    private String confirmPassword;
}
