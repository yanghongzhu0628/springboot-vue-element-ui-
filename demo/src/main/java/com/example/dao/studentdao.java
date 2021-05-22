package com.example.dao;

import com.example.entity.student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface studentdao extends JpaRepository<student,String> {

    @Query(value = "select * from student", nativeQuery = true)
    Page<student> findName(String name,Pageable pageRequest);
    @Query(value = "select * from student where student_id = :student_id", nativeQuery = true)
    List<student> findid(String student_id);
}
