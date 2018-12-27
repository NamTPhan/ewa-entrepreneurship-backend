package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.repository.UserRepository;
import hva.ewa.Entrepreneurship.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ResponseEntity retrieveAllUsers(User user) {

        List<User> listOfUsers = userRepository.listAllUsers(user.getId(), user.getEmail(), user.getFirst_name(), user.getLast_name(), user.getRole(), user.getTeacher());

        return new ResponseEntity<>(listOfUsers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public ResponseEntity<Void> createUser(@RequestBody User user) {

        if (userRepository.doesUserExist(user.getEmail())) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/user/{userid}")
    public ResponseEntity<?> getUser(@PathVariable("userid") Integer id) {
        User user = userRepository.findUserById(id);

        if (user == null) {
            System.out.println("User with ID " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Can be removed
    @RequestMapping(method = RequestMethod.GET, value = "/users/emails")
    public List<User> existingEmail(User user) {

        return userRepository.findAllEmail(user.getEmail());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/user/id/{email}")
    public ResponseEntity findUserIdBasedOnEmail(User user, @PathVariable("email") String email) {

        Integer user_id = userRepository.findByUserEmail(email).getId();

        return new ResponseEntity<>(user_id, HttpStatus.OK);
    }
}
