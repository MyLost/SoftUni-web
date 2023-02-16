package com.softuni.judgeV2.models.dtos;

import com.softuni.judgeV2.models.enums.RoleNameEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private RoleNameEnum name;

}
