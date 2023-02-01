package com.softuni.judgeV2.models.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDto {

    private Long id;
    private String name;
    private LocalDateTime startedOn;
    private LocalDateTime dueDate;
}
