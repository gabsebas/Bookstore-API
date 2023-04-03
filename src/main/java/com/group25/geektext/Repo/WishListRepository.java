package com.group25.geektext.Repo;

import com.example.demo.WishList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface WishListRepository extends JPaRepository<WishList, Integer> {
    @Query(value = "SELECT * FROM book", nativeQuery = true)
    List<WishList> findAllBooks();

}
