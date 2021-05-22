package com.example.controller;

import com.example.common.Result;
import com.example.entity.teacher;
import com.example.service.teacherservice;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class teachercontroller {

    @Resource
    private teacherservice teacherservice;

    @PostMapping
    public Result add(@RequestBody teacher teacher){
        teacherservice.add(teacher);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody teacher teacher){
        teacherservice.update(teacher);
        return Result.success();
    }
    @DeleteMapping("/{teacher_id}")
    public Result delete(@PathVariable String teacher_id){
        teacherservice.delete(teacher_id);
        return Result.success();
    }
    @GetMapping("/{teacher_id}")
    public Result<List<teacher>> find_byid(@PathVariable String teacher_id){
        return Result.success(teacherservice.find_byid(teacher_id));
    }
    @GetMapping("/page")
    public Result<Page<teacher>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                              @RequestParam(required = false) String name) {
        return Result.success(teacherservice.findpage(pageNum, pageSize, name));
    }
}
