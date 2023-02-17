package com.softuni.judgeV2.services.impl;

import com.softuni.judgeV2.models.entities.RoleEntity;
import com.softuni.judgeV2.models.enums.RoleNameEnum;
import com.softuni.judgeV2.repositories.RoleRepository;
import com.softuni.judgeV2.services.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void initRoles() {
        if(roleRepository.count() == 0 ) {
            RoleEntity admin = new RoleEntity(RoleNameEnum.ADMIN);
            RoleEntity user = new RoleEntity(RoleNameEnum.USER);

            roleRepository.save(admin);
            roleRepository.save(user);
        }
    }

    @Override
    public RoleEntity findRole(RoleNameEnum roleNameEnum) {
        return roleRepository.findByName(roleNameEnum).orElse(null);
    }
}
