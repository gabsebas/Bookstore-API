package com.store.store.controller;

import com.store.store.model.AuthorInfo;
import com.store.store.repository.MySqlRepositoryAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Map;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    MySqlRepositoryAuthor mySqlRepositoryAuthor;

    @GetMapping("/get-all-authors")
    public List<AuthorInfo> getAllAuthorInfo() {

        mySqlRepositoryAuthor.findAll();
        return mySqlRepositoryAuthor.findAll();
    }

    @PostMapping("/add-author")
    public AuthorInfo create(@RequestBody Map<String, String> body){

        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        String bio = body.get("bio");
        String autPublisher = body.get("autPublisher");

        AuthorInfo newAuthor = new AuthorInfo(firstName, lastName,bio,autPublisher);

        return mySqlRepositoryAuthor.save(newAuthor);

    }

    @GetMapping("/get-books/author/{last_name}")
    public AuthorInfo getAllBooksByAuthorInfo(@PathVariable("last_name") String lastName) {
        Optional<AuthorInfo> authorInfoOptional = mySqlRepositoryAuthor.findByLastName(lastName);
        if (authorInfoOptional.isPresent()) {
            // Author found, return author information
            return authorInfoOptional.get();
        } else {
            // Author not found, return null or throw an exception based on your requirements
            return null;
        }
    }
}





