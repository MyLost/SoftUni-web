package com.softuni.judgeV2.services.impl;

import com.softuni.judgeV2.mappers.ExerciseMapper;
import com.softuni.judgeV2.models.dtos.ExerciseDto;
import com.softuni.judgeV2.models.entities.ExerciseEntity;
import com.softuni.judgeV2.repositories.ExercisesRepository;
import com.softuni.judgeV2.services.ExercisesService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExercisesServiceImpl implements ExercisesService {

    private final ExercisesRepository exercisesRepository;

    private final ExerciseMapper exerciseMapper;

    public ExercisesServiceImpl(ExercisesRepository exercisesRepository) {
        this.exercisesRepository = exercisesRepository;
        this.exerciseMapper = Mappers.getMapper(ExerciseMapper.class);
    }

    @Override
    public void addExercise(ExerciseDto dto) {

        exercisesRepository.save(exerciseMapper.fromDto(dto));
    }

    @Override
    public List<String> findAllExerciseNames() {
        return exercisesRepository.findALlExerciseNames();
    }

    @Override
    public boolean check(String exercise) {

        ExerciseEntity entity = exercisesRepository.findByName(exercise).orElse(null);

        return entity.getDueDate().isBefore(LocalDateTime.now());
    }

    @Override
    public ExerciseEntity findByName(String exercise) {
        return exercisesRepository.findByName(exercise).orElse(null);
    }
}
