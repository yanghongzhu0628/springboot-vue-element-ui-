package com.example.service;

import com.example.dao.coursedao;
import com.example.entity.course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class courseservice {

    @Resource
    private coursedao coursedao;

    public void add(course course0){
        coursedao.save(course0);
    }
    public void update(course course0){
        coursedao.save(course0);
    }
    public void delete(String course_id){
        coursedao.deleteById(course_id);
    }
    public List<course> find_byid(String course_id){
        return coursedao.findid(course_id);
    }
    public Page<course> findpage(int pagenum, int pagesize, String name) {
        Sort sort = new Sort(Sort.Direction.ASC, "course_id");
        PageRequest request = PageRequest.of(pagenum-1,pagesize,sort);
        return coursedao.findName(name,request);
    }

}
