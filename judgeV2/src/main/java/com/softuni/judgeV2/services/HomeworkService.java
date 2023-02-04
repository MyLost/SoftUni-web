package com.softuni.judgeV2.services;

import com.softuni.judgeV2.models.dtos.HomeworkDto;
import com.softuni.judgeV2.models.entities.HomeworkEntity;

public interface HomeworkService {
    void addHomework(String exercise, String gitAddress);

     HomeworkDto findHomeworkForScoring();

    HomeworkEntity findById(Long homeworkId);
}
