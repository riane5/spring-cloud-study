package com.riane.feign;

import com.riane.bean.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "zipkin-book-feign")
public interface MyBookService {

    @GetMapping("/book/{id}")
    Book getBook(@PathVariable("id") Integer id);
}
