package com.example.service;

import com.example.dao.bookdao;
import com.example.entity.book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class bookservice {

    @Resource
    private bookdao bookdao;

    public void add(book book0) {
        bookdao.save(book0);
    }
    public void update(book book0) {
        bookdao.save(book0);
    }
    public void delete(String book_id) {
        bookdao.deleteById(book_id);
    }
    public List<book> find_byid(String book_id) {
        return bookdao.findid(book_id);
    }
    public Page<book> findpage(int pagenum, int pagesize, String name) {
        Sort sort = new Sort(Sort.Direction.ASC, "book_id");
        PageRequest request = PageRequest.of(pagenum-1,pagesize,sort);
        return bookdao.findName(name,request);
    }
}
