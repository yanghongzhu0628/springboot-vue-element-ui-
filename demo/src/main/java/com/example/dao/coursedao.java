package com.example.dao;

import com.example.entity.course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface coursedao extends JpaRepository<course,String> {
    @Query(value = "select * from course",nativeQuery = true)
    Page<course> findName(String name, PageRequest request);
    @Query(value = "select * from course where course_id = :course_id", nativeQuery = true)
    List<course> findid(String course_id);
}
