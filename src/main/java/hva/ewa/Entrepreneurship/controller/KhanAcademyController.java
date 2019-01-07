package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.model.KhanAcademyVideo;
import hva.ewa.Entrepreneurship.repository.ExtraCompetenceRepository;
import hva.ewa.Entrepreneurship.repository.KhanAcademyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class KhanAcademyController {

    @Autowired
    private KhanAcademyRepository khanAcademyRepository;
    private ExtraCompetenceRepository extraCompetenceRepository;

    public KhanAcademyController(KhanAcademyRepository khanAcademyRepository) {
        this.khanAcademyRepository = khanAcademyRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/khanacademy/video")
    public ResponseEntity insertVideos(@RequestBody KhanAcademyVideo[] khanAcademyVideo) {

        for (KhanAcademyVideo video : khanAcademyVideo) {
            khanAcademyRepository.save(video);
        }

        if (khanAcademyVideo.length == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(khanAcademyVideo, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/khanacademy/videolist")
    public ResponseEntity videoList(KhanAcademyVideo khanAcademyVideo) {

        List<KhanAcademyVideo> khanAcademyVideoList = khanAcademyRepository.getAllVideos(
                khanAcademyVideo.getId(),
                khanAcademyVideo.getUnique_id(),
                khanAcademyVideo.getTitle(),
                khanAcademyVideo.getDescription(),
                khanAcademyVideo.getImage(),
                khanAcademyVideo.getUrl(),
                khanAcademyVideo.getShow_on_top(),
                khanAcademyVideo.getShow_hide(),
                khanAcademyVideo.getCompetences(),
                khanAcademyVideo.getDeleted());

        return new ResponseEntity<>(khanAcademyVideoList, HttpStatus.OK);
    }

    @PutMapping(value = "/khanacademy/update/{video_id}")
    public ResponseEntity<KhanAcademyVideo> updateVideoKhan(@RequestBody KhanAcademyVideo khanAcademyVideo, @PathVariable("video_id") Integer video_id) {

        KhanAcademyVideo video = khanAcademyRepository.findVideoById(video_id);

        video.setShow_on_top(khanAcademyVideo.getShow_on_top());
        video.setShow_hide(khanAcademyVideo.getShow_hide());
        video.setCompetences(khanAcademyVideo.getCompetences());

        khanAcademyRepository.save(video);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/khanacademy/delete/{video_id}")
    public ResponseEntity<KhanAcademyVideo> deleteVideoKhan(@RequestBody KhanAcademyVideo khanAcademyVideo, @PathVariable("video_id") Integer video_id) {

        KhanAcademyVideo video = khanAcademyRepository.findVideoById(video_id);

        video.setDeleted(khanAcademyVideo.getDeleted());

        khanAcademyRepository.save(video);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/khanacademy/videolist/{user_id}")
    public ResponseEntity personalListUser(@PathVariable("user_id") Integer user_id) {

        List<String> threeCompetences = khanAcademyRepository.getThreeLowestCompetences(user_id);
        String extraCompetence = extraCompetenceRepository.getExtraCompetence(user_id);

        List<KhanAcademyVideo> khanAcademyVideoList = khanAcademyRepository.videoMatchLowestCompetences(
                threeCompetences.get(0), threeCompetences.get(1), threeCompetences.get(2), extraCompetence);

        return new ResponseEntity<>(khanAcademyVideoList, HttpStatus.OK);
    }
}
