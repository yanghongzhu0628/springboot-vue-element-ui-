package com.example.dao;

import com.example.entity.room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface roomdao extends JpaRepository<room,String> {
    @Query(value = "select * from room ", nativeQuery = true)
    Page<room> findName(String name, PageRequest request);
    @Query(value = "select * from room where room_id = :room_id", nativeQuery = true)
    List<room> findid(String room_id);
}
