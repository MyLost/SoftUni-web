package com.resellerapp.model.bindings.users;

import com.resellerapp.vallidation.checkUserExistance.CheckUserExistence;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@CheckUserExistence
public class LoginBindingModel {

    @Size(min=3, max=20, message="Username length must be between 3 and 20 characters!")
    private String username;
    @Size(min=3, max=20, message="Username length must be between 3 and 20 characters!")
    private String password;
}
