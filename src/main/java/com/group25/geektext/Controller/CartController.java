package com.group25.geektext.Controller;

import com.group25.geektext.Models.Cart;
import com.group25.geektext.Repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
 
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    // CRUD operations for entire carts.

    @PostMapping 
    public ResponseEntity addCart(@RequestBody Cart cart){
        cartService.addCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping 
    public ResponseEntity<List<Cart>> getAllCarts(){
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    @PutMapping
    public ResponseEntity updateCart(@RequestBody Cart cart) {
        cartService.updateCart(cart);
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCart(@PathVariable String id) {
        cartService.deleteCart(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // APIs for the CONTENTS of a specific cart (e.g. get/add/remove books)

    @GetMapping("/{cartid}") 
    public ResponseEntity<List<Book>> getCartContents(@PathVariable String cartid){
        return ResponseEntity.ok(cartService.getCartContents(cartid));
    }

    @PutMapping("/{cartid}/addBook/{bookid}")
    public ResponseEntity addBookToCart(@PathVariable String cartid, @PathVariable String bookid) {
        cartService.AddBookToCart(cartid, bookid);
        return ResponseEntity.ok(cartService.getCartContents(cartid));
    }

    @PutMapping("/{cartid}/removeBook/{bookid}")
    public ResponseEntity removeBookFromCart(@PathVariable String cartid, @PathVariable String bookid) {
        cartService.RemoveBookFromCart(cartid, bookid);
        return ResponseEntity.ok(cartService.getCartContents(cartid));
    }

}