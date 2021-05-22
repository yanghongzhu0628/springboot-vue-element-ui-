package com.example.service;

import com.example.dao.readingroomdao;
import com.example.entity.readingroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class readingroomservice {

    @Resource
    private readingroomdao readingroomdao;

    public void add(readingroom readingroom0){
        readingroomdao.save(readingroom0);
    }
    public void update(readingroom readingroom0){
        readingroomdao.save(readingroom0);
    }
    public void delete(String r_room_id){
        readingroomdao.deleteById(r_room_id);
    }
    public List<readingroom> find_byid(String r_room_id){
        return readingroomdao.findid(r_room_id);
    }
    public Page<readingroom> findpage(int pagenum, int pagesize, String name) {
        Sort sort = new Sort(Sort.Direction.ASC, "r_room_id");
        PageRequest request = PageRequest.of(pagenum-1,pagesize,sort);
        return readingroomdao.findName(name,request);
    }
}
