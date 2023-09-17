package com.strr;

import com.strr.redis.model.Book;
import com.strr.redis.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private BookService bookService;

    @Test
    void setBookTest() {
        Book book = new Book();
        book.setId(1);
        book.setName("Spring in action");
        book.setAuthor("xxx");
        bookService.setBook("first book", book);
        System.out.println("set book success.");
    }

    @Test
    void getBookTest() {
        Book book = bookService.getBook("first book");
        if (book != null) {
            System.out.println("get " + book);
        } else {
            System.out.println("get nothing.");
        }
    }

    @Test
    void removeBookTest() {
        Boolean flag = bookService.removeBook("first book");
        if (flag != null && flag) {
            System.out.println("remove success.");
        }
    }
}
