package com.example.controller;


import com.example.common.Result;
import com.example.entity.room;
import com.example.service.roomservice;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/room")
public class roomcontroller {

    @Resource
    private roomservice roomservice;

    @PostMapping
    public Result add(@RequestBody room room){
        roomservice.add(room);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody room room){
        roomservice.update(room);
        return Result.success();
    }
    @DeleteMapping("/{room_id}")
    public Result delete(@PathVariable String room_id){
        roomservice.delete(room_id);
        return Result.success();
    }
    @GetMapping("/{room_id}")
    public Result<List<room>> find_byid(@PathVariable String room_id){
        return Result.success(roomservice.find_byid(room_id));
    }
    @GetMapping("/page")
    public Result<Page<room>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                              @RequestParam(required = false) String name) {
        return Result.success(roomservice.findpage(pageNum, pageSize, name));
    }

}
