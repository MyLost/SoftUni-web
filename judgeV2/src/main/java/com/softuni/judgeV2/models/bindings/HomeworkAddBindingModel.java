package com.softuni.judgeV2.models.bindings;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeworkAddBindingModel {


    private String exercise;

    @NotNull
    @Pattern(regexp="https:\\/\\/github\\.com\\/.+", message="Enter valid git message")
    private String gitAddress;
}
