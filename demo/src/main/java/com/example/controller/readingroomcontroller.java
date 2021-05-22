package com.example.controller;

import com.example.common.Result;
import com.example.entity.readingroom;
import com.example.service.readingroomservice;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/readingroom")
public class readingroomcontroller {

    @Resource
    private readingroomservice readingroomservice;

    @PostMapping
    public Result add(@RequestBody readingroom readingroom){
        readingroomservice.add(readingroom);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody readingroom readingroom){
        readingroomservice.update(readingroom);
        return Result.success();
    }
    @DeleteMapping("/{r_room_id}")
    public Result delete(@PathVariable String r_room_id){
        readingroomservice.delete(r_room_id);
        return Result.success();
    }
    @GetMapping("/{r_room_id}")
    public Result<List<readingroom>> find_byid(@PathVariable String r_room_id){
        return Result.success(readingroomservice.find_byid(r_room_id));
    }
    @GetMapping("/page")
    public Result<Page<readingroom>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                         @RequestParam(defaultValue = "10") Integer pageSize,
                                         @RequestParam(required = false) String name) {
        return Result.success(readingroomservice.findpage(pageNum, pageSize, name));
    }
}
