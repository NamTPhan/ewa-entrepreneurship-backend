package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.model.Result;
import hva.ewa.Entrepreneurship.model.User;
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

    public ResultController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/results/user/{user_id}")
    public ResponseEntity<Void> getResults(User user, @PathVariable("user_id") Integer user_id) {

        if (resultRepository.doesUserHasResult(user_id)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        resultList = resultRepository.getAllResults(user_id);

        return new ResponseEntity(resultList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/results/scores/{user_id}")
    public ResponseEntity orderResultsScore(User user, @PathVariable("user_id") Integer user_id) {

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

    @RequestMapping(method = RequestMethod.GET, value = "/results/dates/{user_id}")
    public ResponseEntity<Void> getResultsDates(User user, @PathVariable("user_id") Integer user_id) {

        List<String> dateList = resultRepository.getAllResultsDates(user_id);

        return new ResponseEntity(dateList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/results/user/{user_id}/{date_finished}")
    public ResponseEntity<Void> getSelectedTestResults(User user, @PathVariable("user_id") Integer user_id, @PathVariable("date_finished") String date_finished) {

        resultList = resultRepository.getAllSelectedTestResults(user_id, date_finished);

        return new ResponseEntity(resultList, HttpStatus.OK);
    }
}
