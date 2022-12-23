package com.doggy.store;

import com.doggy.domain.Book;
import com.doggy.domain.Rating;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private final AuthorRepository authorRepository;
    private List<Book> books = new ArrayList<>();

    public BookRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findOne(Integer id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PostConstruct
    private void init() {
        books.add(new Book(1,
                "Reactive Spring",
                439,
                Rating.FIVE_STARS,
                authorRepository.findByName("Josh Long")));

        books.add(new Book(2,
                "Spring Boot Up & Running",
                322,
                Rating.THREE_STARS,
                authorRepository.findByName("Mark Heckler")));

        books.add(new Book(3,
                "Hacking with Spring Boot 2.3",
                302,
                Rating.FIVE_STARS,
                authorRepository.findByName("Greg Turnquist")));

    }
}
