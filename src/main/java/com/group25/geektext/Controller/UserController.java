package com.group25.geektext.Controller;
import com.group25.geektext.Models.User;
import com.group25.geektext.Repo.MySqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

   @Autowired
   MySqlRepository mySqlRepository;

   @GetMapping("/get-all-users")
    public List<User> getAllUsers(){
       return mySqlRepository.findAll();
   }
   @GetMapping("/get-user/{username}")
   public User getSingleUser(@PathVariable String username) {
      return mySqlRepository.findByUsername(username).get();
   }

   @PostMapping("/create-user")
   public User createUser(@RequestBody Map<String,String> body){
      String username = body.get("username");
      String first_name = body.get("first_name");
      String password = body.get("password");
      String last_name = body.get("last_name");
      String email = body.get("email");
      String home_address = body.get("home_address");
      User newUser = new User(username,password,first_name,last_name,email,home_address);

      return mySqlRepository.save(newUser);
   }


   @PutMapping("/update-user/{username}")
   public User updateUser(@PathVariable("username") String username,
                          @RequestBody Map<String, String> body){
      User currentUser = mySqlRepository.findByUsername(username).get();
      currentUser.setUsername(body.get("username"));
      currentUser.setUsername(body.get("password"));
      currentUser.setFirst_name(body.get("first_name"));
      currentUser.setLast_name(body.get("last_name"));
      currentUser.setHome_address(body.get("home_address"));

      mySqlRepository.save(currentUser);
      return currentUser;
   }
}
