package com.example.dao;

import com.example.entity.teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface teacherdao extends JpaRepository<teacher,String> {

    @Query(value ="select * from teacher ",nativeQuery = true)
    Page<teacher> findName(String name, PageRequest request);
    @Query(value = "select * from teacher where teacher_id = :teacher_id", nativeQuery = true)
    List<teacher> findid(String teacher_id);
}
