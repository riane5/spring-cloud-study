package com.riane.controller;

import com.riane.bean.Book;
import com.riane.feign.MyBookService;
import com.riane.feign.MySaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyBookService bookService;

    @Autowired
    private MySaleService saleService;

    @GetMapping("buy-book/{id}")
    public String buyBook(@PathVariable Integer id) {
        Book book = bookService.getBook(id);
        if (book != null) {
            String saleBook = saleService.saleBook(book.getPrice() + "");
            return saleBook;
        }
        return "error";
    }
}
