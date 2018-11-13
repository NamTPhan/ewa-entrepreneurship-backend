package hva.ewa.Entrepreneurship.controller;

import hva.ewa.Entrepreneurship.model.KhanAcademyVideo;
import hva.ewa.Entrepreneurship.repository.KhanAcademyRepository;
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

    @RequestMapping(method = RequestMethod.POST, value = "/khanacademy/video")
    public List<KhanAcademyVideo> saveVideos(@RequestBody List<KhanAcademyVideo> khanAcademyVideo) {
        List<KhanAcademyVideo> list = new ArrayList<>();
        for (KhanAcademyVideo video : khanAcademyVideo) {
            System.out.println(khanAcademyVideo);
            list.add(video);
            khanAcademyRepository.save(video);
        }
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/khanacademy/videolist")
    public List<KhanAcademyVideo> videoList(KhanAcademyVideo khanAcademyVideo) {

        return khanAcademyRepository.getAllVideos(khanAcademyVideo.getId(), khanAcademyVideo.getInternal_id(), khanAcademyVideo.getTitle(),
                khanAcademyVideo.getDescription(), khanAcademyVideo.getIcon(), khanAcademyVideo.getIcon_large(),
                khanAcademyVideo.getUrl(), khanAcademyVideo.getShowOnTop(), khanAcademyVideo.getShowHide());
    }
}
