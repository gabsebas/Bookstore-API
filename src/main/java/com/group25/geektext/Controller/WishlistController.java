package com.group25.geektext.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class WishlistController {
  @Autowired // This means to get the bean called BookRepository
  // Which is auto-generated by Spring, we will use it to handle the data
  private BookRepository BookRepository;
  @Autowired
  private WishListRepository WishListRepository;

  private int Wish_List_Id;


  @PostMapping(path = "/add") // Map ONLY POST Requests
  public @ResponseBody String addNewWishList(@RequestParam String Wish_List_Name
          , @RequestParam String UserID) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    WishList w = new WishList();
    w.setWish_List_Name(Wish_List_Name);
    w.setUserID(UserID);
    WishListRepository.save(w);


    return "Saved";
  }

  @PatchMapping("/listAdd/{Wish_List_ID}/{ISBN}")
  public ResponseEntity<WishList> AddNewBook(@PathVariable(value = "Wish_List_ID") Integer Wish_List_ID, @PathVariable(value = "ISBN") String ISBN) {
    try {
      WishList wishList = WishListRepository.findById(Wish_List_ID).get();
      wishList.setISBN(ISBN);
      return new ResponseEntity<WishList>(WishListRepository.save(wishList), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @GetMapping(path = "/lists")
  public @ResponseBody Iterable<WishList> getAllWishList() {
    return WishListRepository.findAll();
  }

  @GetMapping(path = "/lists/{Wish_List_ID}")
  public ResponseEntity<WishList> getBooksById(@PathVariable(value = "Wish_List_ID") Integer Wish_List_ID)
          throws ResourceNotFoundException {
    WishList wishlist = WishListRepository.findById(Wish_List_ID)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + Wish_List_ID));
    return ResponseEntity.ok().body(wishlist);

  }

  @DeleteMapping("/delete/{id}")
  public void deleteEmployee(@PathVariable(value = "id") Integer Wish_List_ID)
          throws ResourceNotFoundException {
    WishList wishList = WishListRepository.findById(Wish_List_ID)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + Wish_List_ID));
    WishListRepository.delete(wishList);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);

  }
}



