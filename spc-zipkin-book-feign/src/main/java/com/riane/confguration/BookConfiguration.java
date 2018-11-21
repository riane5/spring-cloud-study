package com.riane.confguration;

import com.riane.bean.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfiguration {

    @Bean
    public Book book() {
        Book book = new Book();
        book.setId(1);
        book.setName("Java");
        book.setPrice(21.0f);
        return book;
    }
}
