package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.model.Class;
import hva.ewa.Entrepreneurship.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ClassController {

    @Autowired
    private ClassRepository classRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/class")
    public ResponseEntity createClass(@RequestBody Class createdClass) {

        if (classRepository.doesClassExists(createdClass.getClass_name())) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        classRepository.save(createdClass);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/class/{class_id}")
    public ResponseEntity updateClassOfUser(@RequestBody Class createdClass, @PathVariable("class_id") Integer class_id) {

        Class currentClass = classRepository.findClassById(class_id);

        if (currentClass == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentClass.setClass_name(createdClass.getClass_name());
        classRepository.updateClass(createdClass.getClass_name(), class_id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/class/list/teacher/{user_id}")
    public ResponseEntity getAllClassesOfTeacher(@PathVariable("user_id") Integer user_id) {

        List<Class> classList = classRepository.listAllClasses(user_id);

        return new ResponseEntity(classList, HttpStatus.OK);
    }

}
