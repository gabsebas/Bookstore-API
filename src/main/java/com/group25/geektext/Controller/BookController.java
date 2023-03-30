package com.group25.geektext.Controller;

import com.group25.geektext.Models.Book;
import com.group25.geektext.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/book")
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    private Integer book_id;

    @PostMapping(path="/addBook")
    public @ResponseBody String addBook (@RequestParam String isbn,
                                         @RequestParam String name,
                                         @RequestParam String desc,
                                         @RequestParam Double price,
                                         @RequestParam String author,
                                         @RequestParam String genre,
                                         @RequestParam String publisher,
                                         @RequestParam Integer year,
                                         @RequestParam Integer copies,
                                         @RequestParam Double rating) {

        Book n = new Book();
        n.setBook_ID(book_id++);
        n.setISBN(isbn);
        n.setBookName(name);
        n.setDescription(desc);
        n.setPrice(price);
        n.setAuthor(author);
        n.setGenre(genre);
        n.setPublisher(publisher);
        n.setYear_published(year);
        n.setCopies_sold(copies);
        n.setRating(rating);

        bookRepo.save(n);
        return "Book Added!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllBooks() {
        // JSON with all books
        //return bookRepo.findAll();
        return bookRepo.findAllBooks();
    }

    @GetMapping(path="/genre")
    public @ResponseBody Iterable<Book> getBooksByGenre(@RequestParam String genre){
        return bookRepo.findBooksByGenre(genre);
    }

    @GetMapping(path="/bestsellers")
    public @ResponseBody Iterable<Book> getBooksbyCopiesSold(){
        return bookRepo.findBooksbyCopiesSold().subList(0,10);
    }

    /*TODO: May require being revised when Rating is implemented*/
    @GetMapping(path="/ratings")
    public @ResponseBody Iterable<Book> getBooksbyRatings(@RequestParam double rating){
        return bookRepo.findBooksByRatings(rating);
    }

    @GetMapping(path="/publishers")
    public @ResponseBody Iterable<Book> getBooksbyPublishers(@RequestParam String pub){
        return bookRepo.findBooksByPublisher(pub);
    }


    @PatchMapping(path="/updatebooks/{id}")
    public @ResponseBody ResponseEntity<String> updateBooksByPublisher(@PathVariable("id") int id,
                                                                     @RequestParam String pub,
                                                                     @RequestParam int discount)
    {
        List<Book> books = bookRepo.findBooksByPublisher(pub);
        for(Book b: books){
            double discounted = (discount/100.0) * b.getPrice();
            double newPrice = b.getPrice() - discounted;
            b.setPrice(newPrice);
            bookRepo.save(b);
        }

        return new ResponseEntity<String>("Update Success", HttpStatus.OK);
    }

}