package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.repository.UserRepository;
import hva.ewa.Entrepreneurship.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/entrepreneurship")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public User getUser(@RequestBody User user) {

//        System.out.println("User: " + user.getFirstname() + ", " + user.getLastname() + ", " + user.getEmail() + ", " + user.getPassword());
//        user.setFirstname(user.getFirstname());
//        user.setLastname(user.getLastname());
//        user.setEmail(user.getEmail());
//        user.setPassword(user.getPassword());
//        user.setRole(user.getRole());
//        user.setTeacher(user.getTeacher());
        userRepository.save(user);

        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getuser")
    public List<User> existingUser(User user) {

        List<User> userList = userRepository.findAllUsers(user.getEmail(), user.getPassword(), user.getRole());
        System.out.println(userRepository.findAllUsers(user.getEmail(), user.getPassword(), user.getRole()));

        return userList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getemaillist")
    public List<User> existingEmail(User user) {

//        List<User> emailList = );
//        System.out.println(userRepository.findAllEmail(user.getEmail()));

        return userRepository.findAllEmail(user.getEmail());
    }

}
