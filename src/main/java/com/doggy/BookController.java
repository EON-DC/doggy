package com.doggy;

import com.doggy.domain.Book;
import com.doggy.store.BookRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //@SchemaMapping(typeName = "Query", value = "allBooks")
    @QueryMapping(value = "allBooks")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


}
