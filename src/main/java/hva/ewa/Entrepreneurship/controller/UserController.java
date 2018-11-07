package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.repository.UserRepository;
import hva.ewa.Entrepreneurship.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UserController {

    private UserRepository userRepository;

//    @RequestMapping(method = RequestMethod.GET, value = "/json")
//    public String returnJSON() {
//
//        String hello = "hello";
//
//        return hello;
//    }

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/update")
    public User getUser(@RequestBody User user) {

        userRepository.save(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> existingUser(User user) {

        return userRepository.findAllUsers(user.getEmail(), user.getPassword(), user.getRole());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/emails")
    public List<User> existingEmail(User user) {

        return userRepository.findAllEmail(user.getEmail());
    }

}
