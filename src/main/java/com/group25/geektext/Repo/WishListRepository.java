package com.group25.geektext.Repo;

import com.example.demo.WishList;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface WishListRepository extends CrudRepository<WishList, Integer> {


}
