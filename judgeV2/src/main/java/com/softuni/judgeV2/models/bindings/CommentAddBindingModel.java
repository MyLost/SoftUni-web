package com.softuni.judgeV2.models.bindings;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentAddBindingModel {

    @Min(value=2, message = "Score must be more than 2")
    @Max(value = 6, message = "Score must be than 6")
    @NotNull
    private Integer score;
    @Size(min = 3, message = "Text content length must be more than 3")
    @NotBlank(message = "Cannot be empty")
    private String textContent;

    @NotNull
    private Long homeworkId;

}
