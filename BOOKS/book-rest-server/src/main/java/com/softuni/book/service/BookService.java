package com.softuni.book.service;

import com.softuni.book.model.dtos.AuthorDto;
import com.softuni.book.model.dtos.BookDto;
import com.softuni.book.model.entity.AuthorEntity;
import com.softuni.book.model.entity.BookEntity;
import com.softuni.book.repository.AuthorRepository;
import com.softuni.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    public long createBook(BookDto newBook) {
        String authorName = newBook.getAuthor().getName();
        Optional<AuthorEntity> authorOpt = this.authorRepository.findAuthorEntityByName(authorName);

        BookEntity newBookEntity = BookEntity.builder().
                title(newBook.getTitle()).
                isbn(newBook.getIsbn()).
                author(authorOpt.orElseGet(() -> createNewAuthor(authorName))).build();

        return bookRepository.save(newBookEntity).getId();
    }

    private AuthorEntity createNewAuthor(String authorName) {
        return authorRepository.save(AuthorEntity.builder().name(authorName).build());
    }

    public void deleteById(Long bookId) {
        bookRepository.
                findById(bookId).
                ifPresent(bookRepository::delete);
    }

    public Optional<BookDto> findBookById(Long bookId) {
        return bookRepository.
                findById(bookId).
                map(this::map);
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().
                stream().
                map(this::map).
                toList();
    }

    private BookDto map(BookEntity bookEntity) {

        AuthorDto authorDTO = new AuthorDto().builder().
                name(bookEntity.getAuthor().getName()).build();

        return  BookDto.builder().
                id(bookEntity.getId()).
                author(authorDTO).
                isbn(bookEntity.getIsbn()).
                title(bookEntity.getTitle()).build();
    }
}
