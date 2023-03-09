package com.group25.geektext.Controller;

import com.group25.geektext.Models.Book;
import com.group25.geektext.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/book") // after Application, /book
public class BookController {
    @Autowired // get the repo
    private BookRepo bookRepo;

    @PostMapping(path="/addBook") // Only POST req
    public @ResponseBody String addBook (@RequestParam String isbn
                                        ,@RequestParam String name,
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

    @GetMapping(path="/ratings")
    public @ResponseBody Iterable<Book> getBooksbyRatings(@RequestParam double rating){
        return bookRepo.findBooksByRatings(rating);
    }


    /*TODO: Debug this*/

//    @PatchMapping(path="/updatebooks/{id}")
//    public @ResponseBody ResponseEntity<Book> updateBooksByPublisher(@PathVariable int id, @RequestParam String pub,
//                                                                     @RequestParam int discount)
//    {
//        updateBookByPublisher(pub, discount);
//    }

//    private void updateBookByPublisher(String pub, int discount){
//        bookRepo.updateBookByPublisher(pub, discount);
//    }

//    @PatchMapping(path="/updatebooks/{pub:[a-zA-Z &+-]*}", consumes = "application/json-patch+json")
//    public ResponseEntity<Book> updatePricesByPublisher(@PathVariable String pub,
//                                                                        @RequestBody JsonPatch patch)
//    {
//        Book b = bookRepo.findBookByPublisher(pub);=-
//        Book bPatched = applyPatchToBook(patch, b);
//        return ResponseEntity.ok(bPatched);
////        for(Book x:bookRepo.findAll()){
////            if(x.getPublisher().equalsIgnoreCase(pub)){
////                x.setPrice(x.getPrice() - ((discount/100) * x.getPrice()));
////                bookRepo.save(x);
////            }
////
////        }
////        //bookRepo.updateBooksByPublisher(pub, discount);
////        return new ResponseEntity<String>("Update Success", HttpStatus.OK);
//    }

}