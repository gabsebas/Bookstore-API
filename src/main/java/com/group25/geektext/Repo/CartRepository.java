package com.group25.geektext.Repo;

import com.group25.geektext.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart, String> {

    @Query("{'id': ?0}")
    Optional<Cart> findById(String id);

    @Query("{'userid': ?0}")
 


  
