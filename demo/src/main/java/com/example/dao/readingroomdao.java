package com.example.dao;

import com.example.entity.readingroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface readingroomdao extends JpaRepository<readingroom,String> {

    @Query(value = "select * from readingroom ", nativeQuery = true)
    Page<readingroom> findName(String name, PageRequest request);
    @Query(value = "select * from readingroom where r_room_id = :r_room_id", nativeQuery = true)
    List<readingroom> findid(String r_room_id);
}
