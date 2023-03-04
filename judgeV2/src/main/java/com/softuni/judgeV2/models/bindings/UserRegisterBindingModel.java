package com.softuni.judgeV2.models.bindings;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterBindingModel {

    @NotNull
    @Length(min=2, message="Username length must be minimum two characters")
    private String username;
    @NotNull
    @Length(min=3, message="Password length must be minimum two characters")
    private String password;
    @NotNull
    private String confirmPassword;
    @NotNull
    @Email(message="Enter valid email address")
    private String email;
    @NotNull
    @Pattern(regexp="https:\\/\\/github\\.com\\/.+", message="Enter valid git message")
    private String git;

}
