package com.group25.geektext.Controller;

import com.group25.geektext.Models.Book;
import com.group25.geektext.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/book") // after Application, /book
public class BookController {
    @Autowired // get the repo
    private BookRepo bookRepo;

    /*TODO:
    *  Retrieve list of books by genre
    *       Request param - genre
    *  Retrieve list of top 10 bestsellers (organize by most copies sold)
    *  Retrieve list of books with >= specified rating
    *       Request param - Rating
    *  Update price of all books by publisher by discount percent
    *       Request param - Discount, publisher*/

    @PostMapping(path="/addBook") // Only POST req
    public @ResponseBody String addBook (@RequestParam String isbn
                                        , @RequestParam String name,
                                         @RequestParam String desc,
                                         @RequestParam Double price,
                                         @RequestParam String author,
                                         @RequestParam String genre,
                                         @RequestParam String publisher,
                                         @RequestParam Integer year,
                                         @RequestParam Integer copies,
                                         @RequestParam Double rating) {
        // @ResponseBody = the returned String is the response, not a view name
        // @RequestParam = it is a parameter from the GET or POST request

        Book n = new Book();
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

    @GetMapping(path="/all") //get books
    public @ResponseBody Iterable<Book> getAllBooks() {
        // JSON with all books
        return bookRepo.findAll();
    }
}