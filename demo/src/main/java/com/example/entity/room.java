package com.example.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="room")
@Entity
public class room {
    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public int getPerson_number() {
        return person_number;
    }

    public void setPerson_number(int person_number) {
        this.person_number = person_number;
    }

    public String getApartment_id() {
        return apartment_id;
    }

    public void setApartment_id(String apartment_id) {
        this.apartment_id = apartment_id;
    }

    @Id
    private String room_id;
    private int person_number;
    private String apartment_id;
}
