package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="readingroom")
@Entity
public class readingroom {
    public String getR_room_id() {
        return r_room_id;
    }

    public void setR_room_id(String r_room_id) {
        this.r_room_id = r_room_id;
    }

    public String getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(String floor_id) {
        this.floor_id = floor_id;
    }

    @Id
    private String r_room_id;
    private String floor_id;

}
