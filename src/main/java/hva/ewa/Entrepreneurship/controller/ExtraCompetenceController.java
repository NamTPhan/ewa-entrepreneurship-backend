package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.repository.ExtraCompetenceRepository;
import hva.ewa.Entrepreneurship.model.ExtraCompetence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ExtraCompetenceController {

    @Autowired
    private ExtraCompetenceRepository extraCompetenceRepository;

    public ExtraCompetenceController(ExtraCompetenceRepository extraCompetenceRepository) {
        this.extraCompetenceRepository = extraCompetenceRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/extracompetence/user")
    public ResponseEntity<?> insertExtraCompetence(@RequestBody ExtraCompetence extraCompetence) {

        extraCompetenceRepository.save(extraCompetence);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
