package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.UserRepository;
import hva.ewa.Entrepreneurship.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @RequestMapping(method = RequestMethod.GET, value = "/json")
//    public String returnJSON() {
//
//        String hello = "hello";
//
//        return hello;
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/update")
    public ResponseEntity<String> getUser(@RequestBody User user) {

//        System.out.println("User: " + user.getFirstname() + ", " + user.getLastname() + ", " + user.getEmail() + ", " + user.getPassword());
//        user.setFirstname(user.getFirstname());
//        user.setLastname(user.getLastname());
//        user.setEmail(user.getEmail());
//        user.setPassword(user.getPassword());
//        user.setRole(user.getRole());
//        user.setTeacher(user.getTeacher());
        userRepository.save(user);
        //return new ResponseEntity<>("Status is OK", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> existingUser(User user) {

//        System.out.println(userRepository.findAllUsers(user.getEmail(), user.getPassword(), user.getRole()));

        return userRepository.findAllUsers(user.getEmail(), user.getPassword(), user.getRole());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/emails")
    public List<User> existingEmail(User user) {

//        System.out.println(userRepository.findAllEmail(user.getEmail()));

        return userRepository.findAllEmail(user.getEmail());
    }

}
