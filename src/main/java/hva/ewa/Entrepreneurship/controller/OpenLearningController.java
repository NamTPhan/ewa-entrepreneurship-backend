package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.model.OpenLearningVideo;
import hva.ewa.Entrepreneurship.repository.OpenLearningVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class OpenLearningController {

    @Autowired
    private OpenLearningVideoRepository openLearningVideoRepository;

    @RequestMapping(method = RequestMethod.POST, value = "openlearning/videos")
    public ResponseEntity<?> saveOpenLearningVideo(@RequestBody OpenLearningVideo[] openLearningVideo) {

        if (openLearningVideo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/openlearning/videos/list")
    public ResponseEntity retrieveAllOpenLearningVideos() {

        List<OpenLearningVideo> videoList = openLearningVideoRepository.listAllVideos();

        return new ResponseEntity<>(videoList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/openlearning/videos/video/{openlearningvideo_id}")
    public ResponseEntity updateOpenLearningVideos(@RequestBody OpenLearningVideo openLearningVideo, @PathVariable("openlearningvideo_id") Integer id) {

        OpenLearningVideo currentVideo = openLearningVideoRepository.findVideoById(id);

        if (currentVideo == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        currentVideo.setShow_on_top(openLearningVideo.getShow_on_top());
        currentVideo.setShow_hide(openLearningVideo.getShow_hide());
        currentVideo.setCompetences(openLearningVideo.getCompetences());
        openLearningVideoRepository.updateOpenLearningVideo(currentVideo.getShow_on_top(), currentVideo.getShow_hide(), currentVideo.getCompetences(), id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/openlearning/videos/video/deleted/{openlearningvideo_id}")
    public ResponseEntity deleteOpenLearningVideos(@RequestBody OpenLearningVideo openLearningVideo, @PathVariable("openlearningvideo_id") Integer id) {

        OpenLearningVideo currentVideo = openLearningVideoRepository.findVideoById(id);

        if (currentVideo == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        currentVideo.setDeleted(openLearningVideo.getDeleted());
        openLearningVideoRepository.updateDeletedOpenLearningVideo(currentVideo.getDeleted(), id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
