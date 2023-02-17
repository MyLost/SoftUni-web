package com.softuni.judgeV2.repositories;

import com.softuni.judgeV2.models.entities.RoleEntity;
import com.softuni.judgeV2.models.enums.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName (RoleNameEnum roleNameEnum);
}
