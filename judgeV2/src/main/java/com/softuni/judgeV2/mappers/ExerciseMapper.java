package com.softuni.judgeV2.mappers;

import com.softuni.judgeV2.models.bindings.ExerciseAddBindingModel;
import com.softuni.judgeV2.models.bindings.UserRegisterBindingModel;
import com.softuni.judgeV2.models.dtos.ExerciseDto;
import com.softuni.judgeV2.models.dtos.UserDto;
import com.softuni.judgeV2.models.entities.ExerciseEntity;
import com.softuni.judgeV2.models.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper

public interface ExerciseMapper {

    ExerciseDto modelToDto(ExerciseAddBindingModel exerciseAddBindingModel);

    ExerciseDto entityToDto(ExerciseEntity exerciseEntity);

    ExerciseEntity fromDto (ExerciseDto dto);
}
