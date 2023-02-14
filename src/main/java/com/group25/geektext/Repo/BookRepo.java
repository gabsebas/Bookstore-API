package com.group25.geektext.Repo;

import com.group25.geektext.Models.Book;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BookRepo extends CrudRepository<Book, Integer> {

}