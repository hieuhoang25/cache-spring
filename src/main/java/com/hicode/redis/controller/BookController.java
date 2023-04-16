package com.hicode.redis.controller;

import com.hicode.redis.model.Book;
import com.hicode.redis.repository.BookRepository;
import com.hicode.redis.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;
    private BookRepository bookRepository;
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(bookService.fetchAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(bookService.fetchOne(id));
    }
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Book book){
        return ResponseEntity.ok(bookService.create(book));
    }
    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody Book book){
        return ResponseEntity.ok(bookService.update(book));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }

}
