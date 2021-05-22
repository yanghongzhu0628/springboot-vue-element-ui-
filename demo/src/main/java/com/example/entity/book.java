package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="book")
@Entity
public class book {
    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getR_room_id() {
        return r_room_id;
    }

    public void setR_room_id(String r_room_id) {
        this.r_room_id = r_room_id;
    }

    public String getList_id() {
        return list_id;
    }

    public void setList_id(String list_id) {
        this.list_id = list_id;
    }

    @Id
    private String book_id;
    private String book_name;
    private String r_room_id;
    private String list_id;

}
