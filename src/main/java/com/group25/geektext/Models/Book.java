package com.group25.geektext.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity //Make a table out of this class
public class Book {
    @Id //Primary key?
    @Column
    private Integer book_ID;

    @Column
    private String ISBN;

    @Column
    private String bookName;

    @Column
    private String description;

    @Column
    private double price;

    @Column
    private String author;

    @Column
    private String genre;

    @Column
    private String publisher;

    @Column
    private Integer year_published;

    @Column
    private Integer copies_sold;

    /*TODO: Rating may be its own class - revise when rating is implemented.*/
    @Column
    private double rating;

    public Integer getBook_ID() {
        return book_ID;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public Integer getYear_published() {
        return year_published;
    }

    public Integer getCopies_sold() {
        return copies_sold;
    }

    public double getRating() {
        return rating;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCopies_sold(Integer copies_sold) {
        this.copies_sold = copies_sold;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear_published(Integer year_published) {
        this.year_published = year_published;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setBook_ID(Integer book_ID) {
        this.book_ID = book_ID;
    }
}