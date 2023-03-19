package com.softuni.judgeV2.repositories;

import com.softuni.judgeV2.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    @Query("Select u.username from UserEntity u order by username")
    List<String> findAllUsernames();

    Optional<UserEntity> findByUsername(String username);
}
