package com.softuni.judgeV2.mappers;

import com.softuni.judgeV2.models.bindings.CommentAddBindingModel;
import com.softuni.judgeV2.models.entities.CommentEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper {

    CommentEntity fromModel(CommentAddBindingModel commentAddBindingModel);
}
