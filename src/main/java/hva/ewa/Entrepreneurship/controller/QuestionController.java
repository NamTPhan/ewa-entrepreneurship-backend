package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.QuestionRepository;
import hva.ewa.Entrepreneurship.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/entrepreneurship")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/getquestions")
    public List<Question> getAllQuestions(Question question) {

        List<Question> questionList = questionRepository.findAllQuestions(question.getId(), question.getDescription_text());

        return questionList;
    }
}
