package com.strr;

import com.strr.mongo.model.Book;
import com.strr.mongo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void addBookTest() {
        Book book = new Book();
        book.setId(1);
        book.setName("Spring in action");
        book.setAuthor("ooo");
        bookRepository.save(book);
        System.out.println("save book success.");
    }

    @Test
    void getBookTest() {
        bookRepository.findById(1).map(book -> {
            System.out.println("get " + book);
            return book;
        });
    }
}
