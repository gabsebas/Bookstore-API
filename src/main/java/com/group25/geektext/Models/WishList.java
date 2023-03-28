package com.group25.geektext.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class WishList {

    @Id

    private int Wish_List_Id;
    private String Wish_List_Name;
    private String UserID;
    private String ISBN;

    public WishList() {  }

    public WishList(String Wish_List_Name, String UserID) {
        this.setWish_List_Name(Wish_List_Name);
        this.setUserID(UserID);
    }

    public WishList(String Wish_List_Name , String UserID, int Wish_List_Id, String ISBN ) {
        this.setWish_List_Name(Wish_List_Name);
        this.setUserID(UserID);
        this.setWish_List_Id(Wish_List_Id);
        this.setISBN (ISBN );
    }

    public String getWish_List_Name() {
        return Wish_List_Name;
    }
    public void setWish_List_Name(String Wish_List_Name) {
        this.Wish_List_Name = Wish_List_Name;
    }

    public String getUserID() {
        return UserID;
    }
    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public int getWish_List_Id() {
        return Wish_List_Id;
    }
    public void setWish_List_Id(int Wish_List_Id) {
        this.Wish_List_Id = Wish_List_Id;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "WishList{" +
                "Wish_List_Name=" + Wish_List_Name +
                ", UserID='" + UserID +
        ", Wish_List_Id= " + Wish_List_Id +
                ", ISBN= " + ISBN  ;
        }
    }



