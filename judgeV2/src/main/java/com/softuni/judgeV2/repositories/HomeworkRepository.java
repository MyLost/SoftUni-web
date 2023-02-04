package com.softuni.judgeV2.repositories;

import com.softuni.judgeV2.models.entities.HomeworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HomeworkRepository extends JpaRepository<HomeworkEntity, Long> {

    Optional<HomeworkEntity> findTop1ByOrderByComments();
}
