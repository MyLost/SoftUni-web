package com.softuni.judgeV2.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class HomeworkDto {

    private Long id;
    private String gitAddress;
    private UserDto author;
    private ExerciseDto exercise;
}
