package com.riane.controller;

import com.riane.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private Book book;

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable Integer id) {
        if (book.getId().equals(id)) {
            return book;
        } else {
            Book bookTmp = new Book();
            bookTmp.setId(2);
            bookTmp.setName("Spring");
            bookTmp.setPrice(39.5f);
            return bookTmp;
        }
    }
}
