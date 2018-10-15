package hva.ewa.Entrepreneurship;

import hva.ewa.Entrepreneurship.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/entrepreneurship")
public class SampleController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/json")
    public String returnJSON() {

        String hello = "hello";

        return hello;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public User getUser(@RequestBody User user) {

        System.out.println("User: " + user.getFirstname() + ", " + user.getLastname() + ", " + user.getEmail() + ", " + user.getPassword());
        user.setFirstname(user.getFirstname());
        user.setLastname(user.getLastname());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        userRepository.save(user);

        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getuser")
    public List<User> existingUser(User user) {

        List<User> userList = userRepository.findAllUsers(user.getEmail(), user.getPassword());
        System.out.println(userRepository.findAllUsers(user.getEmail(), user.getPassword()));

        return userList;
    }


}
