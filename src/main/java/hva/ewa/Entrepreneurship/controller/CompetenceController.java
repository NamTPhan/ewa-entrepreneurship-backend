package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.CompetenceRepository;
import hva.ewa.Entrepreneurship.model.Competence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CompetenceController {

    @Autowired
    private CompetenceRepository competenceRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/competences")
    public List<Competence> getAllCompetences(Competence competence) {

        List<Competence> competenceList = competenceRepository.findAllCompetences(competence.getCompetence_id(), competence.getCompetence());

        return competenceList;
    }
}
