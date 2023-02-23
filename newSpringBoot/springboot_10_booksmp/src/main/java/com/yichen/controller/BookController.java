package com.yichen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yichen.domain.Book;
import com.yichen.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/books.html")
@RestController
@Slf4j
public class BookController {
    @Autowired
    public BookService service;

    @GetMapping
    public List<Book> GetAll() {
        return service.list();
    }

    @PostMapping
    public Boolean Save(@RequestBody Book book) {
        return service.save(book);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable int id) {
        log.info("删除");
//       return service.removeById(id);
        return null;
    }

    @PutMapping
    public Boolean update(@RequestBody Book book) {
        return service.updateById(book);
    }

    @PutMapping("/{id}")
    public Book getById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping("/{current}/{pagesize}")
    public IPage<Book> getPage(@PathVariable int current, @PathVariable int pagesize) {
        return service.getPage(current, pagesize);
    }


}
