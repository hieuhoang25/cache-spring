package com.hicode.redis.service;

import com.hicode.redis.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    List<Book> fetchAll();
    Book create(Book book);

    Book update(Book book);

    Book fetchOne(Integer id);

    void delete(Integer id);
}
