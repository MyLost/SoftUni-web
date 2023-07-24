package com.softuni.book.model.dtos;

import lombok.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class BookDto {

    private Long id;
    private String title;

    @NotEmpty
    @Size(min = 5)
    private String isbn;

    private AuthorDto author;
}
