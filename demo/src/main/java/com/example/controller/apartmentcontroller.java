package com.example.controller;

import com.example.common.Result;
import com.example.entity.apartment;
import com.example.service.apartmentservice;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@RestController
@RequestMapping("/apartment")
public class apartmentcontroller {

    @Resource
    private apartmentservice apartmentservice;

    @PostMapping
    public Result add(@RequestBody apartment apartment){
        apartmentservice.add(apartment);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody apartment apartment){
        apartmentservice.update(apartment);
        return Result.success();
    }
    @DeleteMapping("/{apartment_id}")
    public Result delete(@PathVariable String apartment_id){
        apartmentservice.delete(apartment_id);
        return Result.success();
    }
    @GetMapping("/{apartment_id}")
    public Result<List<apartment>> find_byid(@PathVariable String apartment_id){
        return Result.success(apartmentservice.find_byid(apartment_id));
    }
    @GetMapping("/page")
    public Result<Page<apartment>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                          @RequestParam(required = false) String name) {
        return Result.success(apartmentservice.findpage(pageNum, pageSize, name));
    }
}
