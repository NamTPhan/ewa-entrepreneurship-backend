package hva.ewa.Entrepreneurship.repository;

import hva.ewa.Entrepreneurship.model.ExtraCompetence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ExtraCompetenceRepository extends CrudRepository<ExtraCompetence, Integer> {

    @Query("SELECT i.competence FROM ExtraCompetence i WHERE (i.user_id = :user_id)")
    String getExtraCompetence(@Param("user_id") Integer user_id);

}
