package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.model.Result;
import hva.ewa.Entrepreneurship.model.User;
import hva.ewa.Entrepreneurship.repository.ResultRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ResultController {

    private ResultRepository resultRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/results/users")
    public List<User> getResults(Result result) {

        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/results/testscore")
    public Result insertScore(@RequestBody Result result) {

        resultRepository.save(result);
        return result;
    }
}
