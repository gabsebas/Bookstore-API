package com.store.store.model;

import javax.persistence.*;
import  java.util.ArrayList;


@Entity
@Table(name = "Bookstore")
public class Bookstore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BookID;
    @Column(name = "ISBN")
    private Integer ISBN;
    private String Book_name;
    private String Book_description;
    private Double Price;
    private String Author;
    private String Genre;
    private String Publisher;
    private Integer Year_published;
    @Column(name = "Copies_sold")
    private Integer Copies_sold;

    public Bookstore(Integer ISBN,String Book_name, String Book_description, Double Price, String Author, String Genre, String Publisher, Integer Year_published, Integer Copies_sold){
        this.ISBN = ISBN;
        this.Book_name = Book_name;
        this.Book_description = Book_description;
        this.Price = Price;
        this.Author = Author;
        this.Genre = Genre;
        this.Publisher = Publisher;
        this.Year_published = Year_published;
        this.Copies_sold = Copies_sold;
    }



    public Integer getBookID(){
        return BookID;
    }

    public Integer getISBN() {
        return ISBN;
    }
    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public String getBook_name(){
        return Book_name;
    }

    public void setBook_name(String Book_name) {
        this.Book_name = Book_name;
    }

    public String getBook_description(){
        return Book_description;
    }

    public void setBook_description(String Book_description) {
        this.Book_description = Book_description;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        Double price = this.Price;
    }


    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public Integer getYear_published() {
        return Year_published;
    }

    public void setYear_published(Integer Year_published) {
        this.Year_published = Year_published;
    }

    public Integer getCopies_sold() {
        return Copies_sold;
    }

    public void setCopies_sold(Integer Copies_sold) {
        this.Copies_sold = Copies_sold;
    }
    public Bookstore() {

    }
}
