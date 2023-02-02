package com.softuni.judgeV2.services;

import com.softuni.judgeV2.models.dtos.ExerciseDto;
import com.softuni.judgeV2.models.entities.ExerciseEntity;

import java.util.List;

public interface ExercisesService {
    void addExercise(ExerciseDto dto);

    List<String> findAllExerciseNames();

    boolean check(String exercise);

    ExerciseEntity findByName(String exercise);
}
