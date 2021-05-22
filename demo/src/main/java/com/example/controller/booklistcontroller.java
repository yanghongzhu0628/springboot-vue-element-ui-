package com.example.controller;

import com.example.common.Result;
import com.example.entity.booklist;
import com.example.service.booklistservice;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/booklist")
public class booklistcontroller {

    @Resource
    private booklistservice booklistservice;

    @PostMapping
    public Result add(@RequestBody booklist booklist){
        booklistservice.add(booklist);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody booklist booklist){
        booklistservice.update(booklist);
        return Result.success();
    }
    @DeleteMapping("/{list_id}")
    public Result delete(@PathVariable String list_id){
        booklistservice.delete(list_id);
        return Result.success();
    }
    @GetMapping("/{list_id}")
    public Result<List<booklist>> find_byid(@PathVariable String list_id){
        return Result.success(booklistservice.find_byid(list_id));
    }
    @GetMapping("/page")
    public Result<Page<booklist>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @RequestParam(required = false) String name) {
        return Result.success(booklistservice.findpage(pageNum, pageSize, name));
    }

}
