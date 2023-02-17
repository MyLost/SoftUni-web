package com.softuni.judgeV2.services;

import com.softuni.judgeV2.models.entities.RoleEntity;
import com.softuni.judgeV2.models.enums.RoleNameEnum;

public interface RoleService {
    void initRoles();
    RoleEntity findRole(RoleNameEnum roleNameEnum);
}
