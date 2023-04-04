package com.group25.geektext.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Document("cart")
public class Cart {

    @Id
    private String id;
    @Field("userid")
    private String userid;
    @Field("books")
    private ArrayList<String> books;

    public Cart(String userid, ArrayList<String> books) {
        this.userid = userid;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public ArrayList<String> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<String> books) {
        this.books = books;
    }
}
