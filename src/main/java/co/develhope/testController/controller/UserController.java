package co.develhope.testController.controller;

import co.develhope.testController.entities.User;
import co.develhope.testController.repositories.UserRepository;
import co.develhope.testController.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private UserService userService;

   @PostMapping("/users")
   public ResponseEntity Create(@RequestBody User user) {
      try {
         userService.createUser(user);
         return ResponseEntity.ok().body(user);
      } catch (Exception e) {
         return ResponseEntity.badRequest().body(e.getMessage());
      }
   }


   @GetMapping("/users")
   public List<User> getAll(){
      return userService.getUsers();
   }

   @GetMapping("/users/{id}")
   public User getSingle(@PathVariable long id) {
      return userService.getSingle(id);
   }

   @PutMapping("/users/{id}")
   public User update(@PathVariable long id, @RequestBody @NotNull User user) {

        return userService.update(id, user);

   }

   @GetMapping("/{isActive}")
   public User getIsActive(@PathVariable boolean isActive) {

       return userService.getUserIsActive(isActive);
   }



   @DeleteMapping("/users/{id}")
   public void delete(@PathVariable long id) {
      userRepository.deleteById(id);
   }
}