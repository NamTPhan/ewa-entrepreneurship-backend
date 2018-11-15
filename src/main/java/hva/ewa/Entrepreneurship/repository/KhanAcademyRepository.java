package hva.ewa.Entrepreneurship.repository;

import hva.ewa.Entrepreneurship.model.KhanAcademyVideo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface KhanAcademyRepository extends CrudRepository<KhanAcademyVideo, Integer> {

    @Query("SELECT id, internal_id, title, description, icon, icon_large, url, show_on_top, show_hide, competences FROM KhanAcademyVideo ")
    List<KhanAcademyVideo> getAllVideos(Integer id, String internal_id, String title, String description, String icon,
                                        String icon_large, String url, Integer show_on_top, Integer show_hide, String competences);

    @Query("SELECT u FROM KhanAcademyVideo u WHERE u.id = :video_id")
    KhanAcademyVideo findVideoById(@Param("video_id") Integer video_id);
}


