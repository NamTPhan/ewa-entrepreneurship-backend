package hva.ewa.Entrepreneurship.controller;


import hva.ewa.Entrepreneurship.model.AdditionalVideos;
import hva.ewa.Entrepreneurship.repository.AdditionalVideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AdditionalVideosController {

    @Autowired
    private AdditionalVideosRepository additionalVideosRepository;

    public AdditionalVideosController(AdditionalVideosRepository additionalVideosRepository) {
        this.additionalVideosRepository = additionalVideosRepository;
    }

    //this method will be used to retrieve
    @RequestMapping(method = RequestMethod.POST, value = "/additionalvideo/video/insert/")
    public ResponseEntity insertVideo(@RequestBody AdditionalVideos additionalVideos) {


        additionalVideosRepository.save(additionalVideos);


        if (additionalVideos == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(additionalVideos, HttpStatus.OK);
    }

    //get method this method uses the repository to retrieve all the videos from the database and
    //store it in a list.
    @RequestMapping(method = RequestMethod.GET, value = "/additionalvideos/list")
    public ResponseEntity getAllVideos(AdditionalVideos additionalVideos) {

        List<AdditionalVideos> listOfAdditionalVideos = additionalVideosRepository.getAllVideos(
                additionalVideos.getId(), additionalVideos.getTitle(), additionalVideos.getDescription()
                , additionalVideos.getUrl());

        return new ResponseEntity<>(listOfAdditionalVideos, HttpStatus.OK);
    }
}


