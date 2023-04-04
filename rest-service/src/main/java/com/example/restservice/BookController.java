package com.example.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private ReviewRepository ReviewRepository;

    @GetMapping("/{bookId}/reviews")
    public List<Review> getBookReviews(@PathVariable Long bookId) {
        return ReviewRepository.findByBookId(bookId);
    }

    @PostMapping("/{bookId}/reviews")
    public Review createReview(@PathVariable Long bookId, @RequestBody Review review) {
        return ReviewRepository.save(review);
    }
}
