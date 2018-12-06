package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.model.OpenLearningVideo;
import hva.ewa.Entrepreneurship.repository.OpenLearningVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class OpenLearningController {

    @Autowired
    private OpenLearningVideoRepository openLearningVideoRepository;

    @RequestMapping(method = RequestMethod.POST, value = "openlearning/videos")
    public ResponseEntity<?> saveOpenLearningVideo(@RequestBody OpenLearningVideo[] openLearningVideo) {

        if (openLearningVideo == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        for (OpenLearningVideo video : openLearningVideo) {
            openLearningVideoRepository.save(video);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/openlearning/videos/video/{openlearningvideo_id}")
    public ResponseEntity<?> getVideo(@PathVariable("openlearningvideo_id") Integer id) {
        OpenLearningVideo openLearningVideo = openLearningVideoRepository.findVideoById(id);

        if (openLearningVideo == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
