package com.hicode.redis.service.impl;

import com.hicode.redis.model.Book;
import com.hicode.redis.repository.BookRepository;
import com.hicode.redis.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@EnableCaching
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    @Override
    @Cacheable("books")
    public List<Book> fetchAll() {
//        doLongRunningTask();
        return bookRepository.findAll();
    }

    @Override

    public Book create(Book book) {

        return bookRepository.save(book);
    }

    @Override
    @CacheEvict(value = "book", key = "#book.id")
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Cacheable("book")
    public Book fetchOne(Integer id) {
//        doLongRunningTask();
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    @CacheEvict(value = "book", key = "#id")
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    private void doLongRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
