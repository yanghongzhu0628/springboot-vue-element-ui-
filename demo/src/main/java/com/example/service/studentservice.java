package com.example.service;


import com.example.dao.studentdao;
import com.example.entity.student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class studentservice {
    @Resource
    private studentdao studentdao;

    public void add(student student0) {
        studentdao.save(student0);
    }
    public void update(student student0){
        studentdao.save(student0);
    }
    public void delete(String student_id) {
        studentdao.deleteById(student_id);
    }
    public List<student> find_byid(String student_id) {
        return studentdao.findid(student_id);
    }
    public Page<student> findpage(int pagenum,int pagesize,String name) {
        Sort sort = new Sort(Sort.Direction.ASC, "student_id");
        PageRequest request =PageRequest.of(pagenum-1,pagesize,sort);
        return studentdao.findName(name,request);
    }

}
