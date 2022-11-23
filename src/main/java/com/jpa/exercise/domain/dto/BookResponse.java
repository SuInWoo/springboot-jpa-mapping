package com.jpa.exercise.domain.dto;


import com.jpa.exercise.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long bookId;
    private String bookName;
    private String authorName;
    private String publisherName;

    // BookEntity를 BookResponse Dto로 만들어주는 부분
    public static BookResponse of(Book book) {
        return BookResponse.builder()
                .bookId(book.getId())
                .bookName(book.getName())
                .authorName(book.getAuthor().getName())
                .publisherName(book.getPublisher().getName())
                .build();
    }
}
