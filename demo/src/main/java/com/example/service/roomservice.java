package com.example.service;

import com.example.dao.roomdao;
import com.example.entity.room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class roomservice {

    @Resource
    private roomdao roomdao;

    public void add(room room0){
        roomdao.save(room0);
    }
    public void update(room room0){
        roomdao.save(room0);
    }
    public void delete(String room_id){
        roomdao.deleteById(room_id);
    }
    public List<room> find_byid(String room_id){
        return roomdao.findid(room_id);
    }
    public Page<room> findpage(int pagenum, int pagesize, String name) {
        Sort sort = new Sort(Sort.Direction.ASC, "room_id");
        PageRequest request = PageRequest.of(pagenum-1,pagesize,sort);
        return roomdao.findName(name,request);
    }
}
