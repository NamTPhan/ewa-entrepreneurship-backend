package hva.ewa.Entrepreneurship.repository;


import hva.ewa.Entrepreneurship.model.OpenLearningVideo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OpenLearningVideoRepository extends CrudRepository<OpenLearningVideo, Integer> {

    @Query("SELECT v FROM OpenLearningVideo v WHERE v.id = :openlearningvideo_id")
    OpenLearningVideo findVideoById(@Param("openlearningvideo_id") Integer id);
}
