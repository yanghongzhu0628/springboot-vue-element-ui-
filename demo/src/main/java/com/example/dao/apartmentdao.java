package com.example.dao;

import com.example.entity.apartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface apartmentdao extends JpaRepository<apartment,String> {

    @Query(value = "select * from apartment", nativeQuery = true)
    Page<apartment> findName(String name, Pageable pageRequest);
    @Query(value = "select * from apartment where apartment_id = :apartment_id", nativeQuery = true)
    List<apartment> findid(String apartment_id);
}
