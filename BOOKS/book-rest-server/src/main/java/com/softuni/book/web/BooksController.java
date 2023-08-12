package com.softuni.book.web;

import com.softuni.book.model.dtos.BookDto;
import com.softuni.book.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBook(
        @PageableDefault(
            sort = "bookId",
            direction = Sort.Direction.ASC,
            page = 0,
            size = 3
        )
        Pageable pageable
    ) {
        return ResponseEntity.
                ok(bookService.getAllBooks(pageable));
    }

    @Operation(summary = "Get book by the given ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "If the book was discovered.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookDto.class))}),
                    @ApiResponse(responseCode = "400", description = "If the ID was incorrect."),
                    @ApiResponse(responseCode = "404", description = "If the book was not found.")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long bookId) {
        Optional<BookDto> theBook = bookService.findBookById(bookId);

        return
                theBook.
                        map(ResponseEntity::ok).
                        orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDto> deleteBookById(@PathVariable("id") Long bookId) {
        bookService.deleteById(bookId);

        return ResponseEntity.
                noContent().
                build();
    }

    @PostMapping()
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto newBook,
                                              UriComponentsBuilder uriComponentsBuilder) {
        long newBookId = bookService.createBook(newBook);

        return ResponseEntity.created(uriComponentsBuilder.
                        path("/api/books/{id}").build(newBookId)).
                build();
    }

}
