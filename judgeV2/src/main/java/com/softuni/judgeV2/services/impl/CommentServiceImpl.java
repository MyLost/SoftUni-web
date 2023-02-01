package com.softuni.judgeV2.services.impl;

import com.softuni.judgeV2.mappers.CommentMapper;
import com.softuni.judgeV2.models.bindings.CommentAddBindingModel;
import com.softuni.judgeV2.models.entities.CommentEntity;
import com.softuni.judgeV2.repositories.CommentRepository;
import com.softuni.judgeV2.security.CurrentUser;
import com.softuni.judgeV2.services.CommentService;
import com.softuni.judgeV2.services.HomeworkService;
import com.softuni.judgeV2.services.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final CommentMapper commentMapper;

    private final HomeworkService homeworkService;

    public CommentServiceImpl(CommentRepository commentRepository, UserService userService, CurrentUser currentUser, HomeworkService homeworkService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.currentUser = currentUser;
        this.homeworkService = homeworkService;
        this.commentMapper = Mappers.getMapper(CommentMapper.class);
    }

    @Override
    public void add(CommentAddBindingModel commentAddBindingModel) {

        CommentEntity entity;
        entity = commentMapper.fromModel(commentAddBindingModel);
        entity.setAuthor(userService.findById(currentUser.getId()));
        entity.setHomework(homeworkService.findById(commentAddBindingModel.getHomeworkId()));

        this.commentRepository.save(entity);
    }

    @Override
    public Double findAvgScore() {
        return commentRepository.findAvgScore();
    }

    @Override
    public Map<Integer, Integer> findScoreMap() {
        Map<Integer, Integer> scoreMap = initScoreMap();
        commentRepository.findAll()
                .forEach(commentEntity -> {
                    Integer score = commentEntity.getScore();
                    System.out.println("Score " + score);
                    scoreMap.put(score, scoreMap.get(score) + 1);
                });
        return scoreMap;
    }

    private Map<Integer, Integer> initScoreMap() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i <= 6 ; i++) {
            map.put(i, 0);
        }
        return map;
    }
}
