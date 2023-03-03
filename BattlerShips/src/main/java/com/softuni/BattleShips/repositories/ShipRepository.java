package com.softuni.BattleShips.repositories;

import com.softuni.BattleShips.domain.entities.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity, Long> {

    Optional<ShipEntity> findByName(String name);

    Optional<List<ShipEntity>> findAllByUserId(Long id);
}
