package com.example.service;

import com.example.dao.apartmentdao;
import com.example.entity.apartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class apartmentservice {

    @Resource
    private apartmentdao apartmentdao;

    public void add(apartment apartment0){
        apartmentdao.save(apartment0);
    }
    public void update(apartment apartment0){
        apartmentdao.save(apartment0);
    }
    public void delete(String apartment_id){
        apartmentdao.deleteById(apartment_id);
    }
    public List<apartment> find_byid(String apartment_id){
        return apartmentdao.findid(apartment_id);
    }
    public Page<apartment> findpage(int pagenum,int pagesize,String name) {
        Sort sort = new Sort(Sort.Direction.ASC, "apartment_id");
        PageRequest request = PageRequest.of(pagenum-1,pagesize,sort);
        return apartmentdao.findName(name,request);
    }


}
