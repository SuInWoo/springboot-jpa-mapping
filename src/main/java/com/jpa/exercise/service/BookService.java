package com.jpa.exercise.service;

import com.jpa.exercise.domain.dto.BookResponse;
import com.jpa.exercise.domain.entity.Author;
import com.jpa.exercise.domain.entity.Book;
import com.jpa.exercise.repository.AuthorRepository;
import com.jpa.exercise.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookResponse> getBooks() {
        List<Book> books = bookRepository.findAll();

        List<BookResponse> bookResponses = new ArrayList<>();

        for (Book book : books) {
            Optional<Author> author = authorRepository.findById(book.getAuthorId());
            bookResponses.add(BookResponse.of(book, author.get().getName()));
        }

        return bookResponses;
    }

}
