package com.softuni.judgeV2.models.bindings;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginBindingModel {
    @NotNull
    @Length(min=2, message="Username length must be minimum two characters")
    private String username;
    @NotNull
    @Length(min=3, message="Password length must be minimum three characters")
    private String password;
}
