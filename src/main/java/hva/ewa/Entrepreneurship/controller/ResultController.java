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

    public ResultController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/results/user")
    public List<Result> getResults(Result result) {

        List<Result> resultList = resultRepository.getAllResults(result.getUser_id(), result.getCompetence_id(), result.getScore());

        return resultList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/results/scores")
    public List<Result> orderResultsScore(Result result) {

        List<Result> scoreList = resultRepository.getOrderedScores(result.getUser_id(), result.getCompetence_id(), result.getScore());

        return scoreList;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/results/testscore")
    public Result insertScore(@RequestBody Result result) {

        resultRepository.save(result);
        return result;
    }
}
