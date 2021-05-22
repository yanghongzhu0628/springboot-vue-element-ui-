package com.example.controller;

import com.example.common.Result;
import com.example.entity.student;
import com.example.service.studentservice;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class studentcontroller {


    @Resource
    private studentservice studentservice;

    @PostMapping
    public Result add(@RequestBody student student){
        studentservice.add(student);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody student student){
        studentservice.update(student);
        return Result.success();
    }
    @DeleteMapping({"/{student_id}"})
    public Result delete(@PathVariable String student_id){
        studentservice.delete(student_id);
        return Result.success();
    }
    @GetMapping({"/{student_id}"})
    public Result<List<student>> findbyid(@PathVariable String student_id){
        return Result.success(studentservice.find_byid(student_id));
    }
    @GetMapping("/page")
    public Result<Page<student>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                          @RequestParam(required = false) String name) {
        return Result.success(studentservice.findpage(pageNum, pageSize, name));
    }

}
