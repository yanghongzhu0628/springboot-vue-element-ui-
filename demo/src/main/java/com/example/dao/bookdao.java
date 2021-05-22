package com.example.dao;

import com.example.entity.book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookdao extends JpaRepository<book,String> {
    @Query(value = "select * from book", nativeQuery = true)
    Page<book> findName(String name, PageRequest request);
    @Query(value = "select * from book where book_id = :book_id", nativeQuery = true)
    List<book> findid(String book_id);
}
