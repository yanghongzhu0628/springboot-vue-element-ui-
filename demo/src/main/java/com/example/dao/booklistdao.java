package com.example.dao;

import com.example.entity.booklist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface booklistdao extends JpaRepository<booklist,String> {
    @Query(value = "select * from booklist", nativeQuery = true)
    Page<booklist> findName(String name, PageRequest request);
    @Query(value = "select * from booklist where list_id = list_id", nativeQuery = true)
    List<booklist> findid(String list_id);
}
