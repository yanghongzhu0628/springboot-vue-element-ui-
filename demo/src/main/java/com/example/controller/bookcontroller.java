package com.example.controller;

import com.example.common.Result;
import com.example.entity.book;
import com.example.service.bookservice;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book")
public class bookcontroller {

    @Resource
    private bookservice bookservice;

    @PostMapping
    public Result add(@RequestBody book book){
        bookservice.add(book);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody book book){
        bookservice.update(book);
        return Result.success();
    }
    @DeleteMapping("/{book_id}")
    public Result delete(@PathVariable String book_id){
        bookservice.delete(book_id);
        return Result.success();
    }
    @GetMapping("/{book_id}")
    public Result<List<book>> find_byid(@PathVariable String book_id){
        return Result.success(bookservice.find_byid(book_id));
    }
    @GetMapping("/page")
    public Result<Page<book>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       @RequestParam(required = false) String name) {
        return Result.success(bookservice.findpage(pageNum, pageSize, name));
    }

}
