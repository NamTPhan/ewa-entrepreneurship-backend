package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.model.KhanAcademyVideo;
import hva.ewa.Entrepreneurship.repository.KhanAcademyRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class KhanAcademyController {

    private KhanAcademyRepository khanAcademyRepository;

    public KhanAcademyController(KhanAcademyRepository khanAcademyRepository) {
        this.khanAcademyRepository = khanAcademyRepository;
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/khanacademy/video")
//    public KhanAcademyVideo saveVideos(@RequestBody KhanAcademyVideo khanAcademyVideo) {
//            khanAcademyRepository.save(khanAcademyVideo);
//
//        return khanAcademyVideo;
//    }

//    @RequestMapping(method = RequestMethod.POST, value = "/results/testscore")
//    public Result insertScore(@RequestBody Result result) {
//
//        resultRepository.save(result);
//        return result;
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/khanacademy/video")
    public KhanAcademyVideo saveVideos(@RequestBody KhanAcademyVideo khanAcademyVideo){

//        List<KhanAcademyVideo> list = new ArrayList<>();
//
//        for (KhanAcademyVideo video : khanAcademyVideo) {
//            System.out.println(khanAcademyVideo);
//            list.add(video);
            khanAcademyRepository.save(khanAcademyVideo);
//        }

//        if (list.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return khanAcademyVideo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/khanacademy/videolist")
    public List<KhanAcademyVideo> videoList(KhanAcademyVideo khanAcademyVideo) {

        return khanAcademyRepository.getAllVideos(khanAcademyVideo.getId(), khanAcademyVideo.getInternal_id(), khanAcademyVideo.getTitle(),
                khanAcademyVideo.getDescription(), khanAcademyVideo.getIcon(), khanAcademyVideo.getIcon_large(),
                khanAcademyVideo.getUrl(), khanAcademyVideo.getShow_on_top(), khanAcademyVideo.getShow_hide());
    }
}
