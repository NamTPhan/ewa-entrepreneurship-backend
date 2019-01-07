package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.model.Result;
import hva.ewa.Entrepreneurship.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;
    private List<Result> resultList, scoreList;

    // Constuctor
    public ResultController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    // Get results of user by id
    @RequestMapping(method = RequestMethod.GET, value = "/results/user/{user_id}")
    public ResponseEntity<Void> getResults(@PathVariable("user_id") Integer user_id) {

        if (resultRepository.doesUserHasResult(user_id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        resultList = resultRepository.getAllResults(user_id);

        return new ResponseEntity(resultList, HttpStatus.OK);
    }

    // Get results scores of user by id
    @RequestMapping(method = RequestMethod.GET, value = "/results/scores/user/{user_id}")
    public ResponseEntity orderResultsScore(@PathVariable("user_id") Integer user_id) {

        if (resultRepository.doesUserHasResult(user_id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        scoreList = resultRepository.getOrderedScores(user_id);

        return new ResponseEntity<>(scoreList, HttpStatus.OK);
    }

    // Save results of competence test
    @RequestMapping(method = RequestMethod.POST, value = "/results")
    public ResponseEntity<Void> insertScore(@RequestBody Result result) {

        resultRepository.save(result);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Get dates of competence test made by user's id
    @RequestMapping(method = RequestMethod.GET, value = "/results/dates/user/{user_id}")
    public ResponseEntity<Void> getResultsDates(@PathVariable("user_id") Integer user_id) {

        List<String> dateList = resultRepository.getAllResultsDates(user_id);

        return new ResponseEntity(dateList, HttpStatus.OK);
    }

    // Get selected results of user by id and date
    @RequestMapping(method = RequestMethod.GET, value = "/results/dates/date/{date_finished}/user/{user_id}")
    public ResponseEntity<Void> getSelectedTestResults(@PathVariable("user_id") Integer user_id, @PathVariable("date_finished") String date_finished) {

        resultList = resultRepository.getAllSelectedTestResults(user_id, date_finished);

        return new ResponseEntity(resultList, HttpStatus.OK);
    }
}
