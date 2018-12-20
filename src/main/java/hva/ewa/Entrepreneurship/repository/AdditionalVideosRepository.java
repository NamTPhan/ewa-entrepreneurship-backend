package hva.ewa.Entrepreneurship.repository;

import hva.ewa.Entrepreneurship.model.AdditionalVideos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdditionalVideosRepository extends CrudRepository<AdditionalVideos, Integer> {

    //query retrieves all the data from the database.
    @Query("SELECT id_video, title, description, url FROM AdditionalVideos ")
    List<AdditionalVideos> getAllVideos(Integer id, String title, String description, String url);

    @Query("SELECT u FROM AdditionalVideos u WHERE u.id_video = :id_video")
    AdditionalVideos getVideoFromId(@Param("id_video") Integer id_video);


}