package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.repository.QuestionRepository;
import hva.ewa.Entrepreneurship.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    //get a list of all questions
    @RequestMapping(method = RequestMethod.GET, value = "/questions")
    public List<Question> getAllQuestions(Question question) {

        List<Question> questionList = questionRepository.findAllQuestions(question.getQuestion_id(), question.getDescriptiontext(), question.getCompetence_id());

        System.out.println(questionList.size()); // For testing

        return questionList;
    }
}
