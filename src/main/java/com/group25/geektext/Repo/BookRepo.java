package com.group25.geektext.Repo;

import com.group25.geektext.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM book", nativeQuery = true)
    List<Book> findAllBooks();

    @Query(value = "SELECT * FROM book WHERE genre=:genre", nativeQuery = true)
    List<Book> findBooksByGenre(@Param("genre") String genre);

    @Query(value="SELECT * FROM book ORDER BY copies_sold DESC", nativeQuery=true)
    List<Book> findBooksbyCopiesSold();

    @Query(value="SELECT * FROM book WHERE rating >= :rating", nativeQuery = true)
    List<Book> findBooksByRatings(@Param("rating") double rating);

    @Query(value="SELECT * FROM book WHERE publisher=:publisher", nativeQuery = true)
    List<Book> findBooksByPublisher(@Param("publisher") String publisher);

}