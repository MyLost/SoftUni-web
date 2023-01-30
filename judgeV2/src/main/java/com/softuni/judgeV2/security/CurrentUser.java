package com.softuni.judgeV2.security;

import com.softuni.judgeV2.models.enums.RoleNameEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUser {

    private Long id;
    private String username;
    private RoleNameEnum role;


    public boolean isAnonymous() {
        return this.username == null;
    }

    public boolean isAdmin() {
        return role.equals(RoleNameEnum.ADMIN);
    }
}
