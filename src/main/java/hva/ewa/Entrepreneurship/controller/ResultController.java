package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.model.Result;
import hva.ewa.Entrepreneurship.model.User;
import hva.ewa.Entrepreneurship.repository.ResultRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ResultController {

    private ResultRepository resultRepository;
    private List<Result> resultList, scoreList;

    public ResultController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/results/user/{user_id}")
    public ResponseEntity<Void> getResults(Result result, @PathVariable("user_id") Integer user_id) {

        if (resultRepository.doesUserHasResult(user_id)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        resultList = resultRepository.getAllResults(user_id);

        return new ResponseEntity(resultList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/results/scores/{user_id}")
    public ResponseEntity orderResultsScore(Result result, @PathVariable("user_id") Integer user_id) {

        if (resultRepository.doesUserHasResult(user_id)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        scoreList = resultRepository.getOrderedScores(user_id);

        return new ResponseEntity<>(scoreList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/results/testscore")
    public Result insertScore(@RequestBody Result result) {

        resultRepository.save(result);
        return result;
    }
}
