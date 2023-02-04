package com.softuni.judgeV2.mappers;

import com.softuni.judgeV2.models.dtos.HomeworkDto;
import com.softuni.judgeV2.models.entities.HomeworkEntity;
import org.mapstruct.Mapper;

@Mapper
public interface HomeworkMapper {

    HomeworkDto toDto(HomeworkEntity entity);
}
