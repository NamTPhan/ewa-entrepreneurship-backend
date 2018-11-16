package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.model.KhanAcademyVideo;
import hva.ewa.Entrepreneurship.repository.KhanAcademyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class KhanAcademyController {

    @Autowired
    private KhanAcademyRepository khanAcademyRepository;

    public KhanAcademyController(KhanAcademyRepository khanAcademyRepository) {
        this.khanAcademyRepository = khanAcademyRepository;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/khanacademy/video")
    public ResponseEntity insertVideos(@RequestBody KhanAcademyVideo[] khanAcademyVideo){

        for (KhanAcademyVideo video : khanAcademyVideo) {
            khanAcademyRepository.save(video);
        }

        if (khanAcademyVideo.length == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(khanAcademyVideo,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/khanacademy/videolist")
    public ResponseEntity videoList(KhanAcademyVideo khanAcademyVideo) {

        List<KhanAcademyVideo> khanAcademyVideoList = khanAcademyRepository.getAllVideos(khanAcademyVideo.getId(), khanAcademyVideo.getInternal_id(), khanAcademyVideo.getTitle(),
                khanAcademyVideo.getDescription(), khanAcademyVideo.getIcon(), khanAcademyVideo.getIcon_large(),
                khanAcademyVideo.getUrl(), khanAcademyVideo.getShow_on_top(), khanAcademyVideo.getShow_hide());

        return new ResponseEntity<>(khanAcademyVideoList,HttpStatus.OK);
    }
}
