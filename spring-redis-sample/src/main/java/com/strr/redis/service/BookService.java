package com.strr.redis.service;

import com.strr.redis.model.Book;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookService {
    @Resource
    private RedisTemplate<String, Book> redisTemplate;

    public void setBook(String key, Book book) {
        redisTemplate.opsForValue().set(key, book);
    }

    public Book getBook(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Boolean removeBook(String key) {
        return redisTemplate.delete(key);
    }
}
