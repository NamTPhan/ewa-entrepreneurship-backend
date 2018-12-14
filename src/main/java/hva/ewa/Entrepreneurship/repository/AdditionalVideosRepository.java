package hva.ewa.Entrepreneurship.repository;

import hva.ewa.Entrepreneurship.model.AdditionalVideos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdditionalVideosRepository extends CrudRepository<AdditionalVideos, Integer> {

    //query retrieves all the data from the database.
    @Query("SELECT id, title, description, url FROM AdditionalVideos ")
    List<AdditionalVideos> getAllVideos(Integer id, String title, String description, String url);


}
