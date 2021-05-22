package com.example.service;

import com.example.dao.teacherdao;
import com.example.entity.teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class teacherservice {

    @Resource
    private teacherdao teacherdao;

    public void add(teacher teacher0){
        teacherdao.save(teacher0);
    }
    public void update(teacher teacher0){
        teacherdao.save(teacher0);
    }
    public void delete(String teacher_id){
        teacherdao.deleteById(teacher_id);
    }
    public List<teacher> find_byid(String teacher_id){
        return teacherdao.findid(teacher_id);
    }
    public Page<teacher> findpage(int pagenum, int pagesize, String name) {
        Sort sort = new Sort(Sort.Direction.ASC, "teacher_id");
        PageRequest request = PageRequest.of(pagenum-1,pagesize,sort);
        return teacherdao.findName(name,request);
    }
}
