package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.UserRepository;
import hva.ewa.Entrepreneurship.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //Can be used to populate list of users for admin
//    public ResponseEntity<List<User>> retrieveAllUsers() {
//        List<User> users;
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public ResponseEntity<Void> createUser(@RequestBody User user) {

        if (userRepository.doesUserExist(user.getEmail())) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/update/{userid}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userid") Integer id) {

        User currentUser = userRepository.findUserById(id);

        if (currentUser == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        currentUser.setFirstname(user.getFirstname());
        currentUser.setLastname(user.getLastname());
        currentUser.setEmail(user.getEmail());
        userRepository.updateUser(user.getFirstname(), user.getLastname(), user.getEmail(), id);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/login")
//    public ResponseEntity<User> login(@RequestBody User user) {
//
//        User currentUser = userRepository.findByUserEmail(user.getEmail());
//
//        if (currentUser.getEmail().equals(user.getEmail()) && currentUser.getPassword().equals(user.getPassword())) {
//            return new ResponseEntity<User>(user, HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//
//
//    }

    //Can be removed
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> existingUser(User user) {

        return userRepository.findAllUsers(user.getEmail(), user.getPassword(), user.getRole());
    }

    //Can be removed
    @RequestMapping(method = RequestMethod.GET, value = "/users/emails")
    public List<User> existingEmail(User user) {

        return userRepository.findAllEmail(user.getEmail());
    }

//    @GetMapping("/enterStudent")
//    @PreAuthorize("hasAnyRole('Student')")
//    public ResponseEntity<?> enterAsStudent() {
//        return new ResponseEntity<>("You are student", HttpStatus.OK);
//    }
//
//    @GetMapping("/enterTeacher")
//    @PreAuthorize("hasAnyRole('Teacher')")
//    public ResponseEntity<?> enterAsTeacher() {
//        System.out.println("Responded teacher");
//        return new ResponseEntity<>("You are teacher", HttpStatus.OK);
//    }

}
