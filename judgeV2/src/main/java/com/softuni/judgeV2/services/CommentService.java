package com.softuni.judgeV2.services;

import com.softuni.judgeV2.models.bindings.CommentAddBindingModel;

import java.util.Map;

public interface CommentService {
    void add(CommentAddBindingModel commentAddBindingModel);

    Double findAvgScore();

    Map<Integer, Integer> findScoreMap();
}
