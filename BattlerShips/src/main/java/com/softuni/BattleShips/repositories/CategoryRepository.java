package com.softuni.BattleShips.repositories;

import com.softuni.BattleShips.domain.entities.CategoryEntity;
import com.softuni.BattleShips.domain.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(CategoryType name);
}
