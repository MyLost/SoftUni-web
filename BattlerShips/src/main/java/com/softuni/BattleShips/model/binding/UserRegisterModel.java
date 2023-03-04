package com.softuni.BattleShips.model.binding;


import com.softuni.BattleShips.validations.password.PasswordMatch;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@PasswordMatch
public class UserRegisterModel {

    @Size(min=3, max = 10)
    private String username;
    @Size(min=5, max = 20)
    private String fullName;
    @Size(min=3)
    private String password;
    @NotNull
    @NotBlank
    private String confirmPassword;
    @Email
    private String email;
}
