package com.softuni.judgeV2.mappers;

import com.softuni.judgeV2.models.bindings.UserRegisterBindingModel;
import com.softuni.judgeV2.models.dtos.UserDto;
import com.softuni.judgeV2.models.dtos.UserProfileDto;
import com.softuni.judgeV2.models.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto modelToDto(UserRegisterBindingModel bindingModel);

    UserDto entityToDto(UserEntity bindingModel);

    UserEntity fromDto (UserDto dto);

    UserProfileDto profileFromEntity(UserEntity bindingModel);
}
