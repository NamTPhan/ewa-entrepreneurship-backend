package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.model.Class;
import hva.ewa.Entrepreneurship.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ClassController {

    @Autowired
    private ClassRepository classRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/class")
    public ResponseEntity createClass(@RequestBody Class createdClass) {

        if (classRepository.existsById(createdClass.getClass_id())) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        classRepository.save(createdClass);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
