package com.example.service;

import com.example.dao.booklistdao;
import com.example.entity.booklist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class booklistservice {

    @Resource
    private booklistdao booklistdao;

    public void add(booklist booklist0){
        booklistdao.save(booklist0);
    }
    public void update(booklist booklist0){
        booklistdao.save(booklist0);
    }
    public void delete(String list_id){
        booklistdao.deleteById(list_id);
    }
    public List<booklist> find_byid(String list_id){
        return booklistdao.findid(list_id);
    }
    public Page<booklist> findpage(int pagenum, int pagesize, String name) {
        Sort sort = new Sort(Sort.Direction.ASC, "list_id");
        PageRequest request = PageRequest.of(pagenum-1,pagesize,sort);
        return booklistdao.findName(name,request);
    }

}
