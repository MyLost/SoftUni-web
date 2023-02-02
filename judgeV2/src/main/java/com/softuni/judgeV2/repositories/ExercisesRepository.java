package com.softuni.judgeV2.repositories;

import com.softuni.judgeV2.models.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExercisesRepository extends JpaRepository<ExerciseEntity, Long> {

    @Query("SELECT e.name FROM ExerciseEntity e ORDER BY e.name")
    List<String> findALlExerciseNames();

    Optional<ExerciseEntity> findByName(String name);
}
