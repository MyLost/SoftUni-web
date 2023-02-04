package com.softuni.judgeV2.services.impl;

import com.softuni.judgeV2.mappers.HomeworkMapper;
import com.softuni.judgeV2.models.dtos.HomeworkDto;
import com.softuni.judgeV2.models.entities.HomeworkEntity;
import com.softuni.judgeV2.repositories.HomeworkRepository;
import com.softuni.judgeV2.security.CurrentUser;
import com.softuni.judgeV2.services.ExercisesService;
import com.softuni.judgeV2.services.HomeworkService;
import com.softuni.judgeV2.services.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;
    private final ExercisesService exercisesService;
    private final CurrentUser currentUser;
    private final UserService userService;

    private final HomeworkMapper homeworkMapper;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, ExercisesService exercisesService, CurrentUser currentUser, UserService userService) {
        this.homeworkRepository = homeworkRepository;
        this.exercisesService = exercisesService;
        this.currentUser = currentUser;
        this.userService = userService;
        this.homeworkMapper = Mappers.getMapper(HomeworkMapper.class);
    }

    @Override
    public void addHomework(String exercise, String gitAddress) {
        HomeworkEntity entity = new HomeworkEntity();
        entity.setGitAddress(gitAddress);
        entity.setAddedOn(LocalDateTime.now());
        entity.setExercise(exercisesService.findByName(exercise));
        entity.setAuthor(userService.findById(currentUser.getId()));

        homeworkRepository.save(entity);
    }

    @Override
    public HomeworkDto findHomeworkForScoring() {
        return homeworkMapper.toDto(homeworkRepository.findTop1ByOrderByComments().orElse(null));
    }

    @Override
    public HomeworkEntity findById(Long homeworkId) {
        return homeworkRepository.findById(homeworkId).orElse(null);
    }

}
