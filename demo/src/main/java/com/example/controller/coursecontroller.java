package com.example.controller;

import com.example.common.Result;
import com.example.entity.course;
import com.example.service.courseservice;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/course")
public class coursecontroller {

    @Resource
    private courseservice courseservice;

    @PostMapping
    public Result add(@RequestBody course course){
        courseservice.add(course);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody course course){
        courseservice.update(course);
        return Result.success();
    }
    @DeleteMapping("/{course_id}")
    public Result delete(@PathVariable String course_id){
        courseservice.delete(course_id);
        return Result.success();
    }
    @GetMapping("/{course_id}")
    public Result<List<course>> find_byid(@PathVariable String course_id){
        return Result.success(courseservice.find_byid(course_id));
    }
    @GetMapping("/page")
    public Result<Page<course>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @RequestParam(required = false) String name) {
        return Result.success(courseservice.findpage(pageNum, pageSize, name));
    }

}
