package com.hicode.redis.controller;


import com.hicode.redis.model.Book;
import com.hicode.redis.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/redis")
public class RedisController {
    private RedisTemplate<String, Object> redisTemplate;
    private BookService bookService;

    @GetMapping("")
    public ResponseEntity<?> create(){
        redisTemplate.opsForValue().set("key", bookService.fetchAll());
        return ResponseEntity.ok().build();
    }
}
