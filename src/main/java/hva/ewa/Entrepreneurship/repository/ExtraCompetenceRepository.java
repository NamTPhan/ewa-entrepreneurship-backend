package hva.ewa.Entrepreneurship.repository;

import hva.ewa.Entrepreneurship.model.ExtraCompetence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExtraCompetenceRepository extends CrudRepository<ExtraCompetence, Integer> {

    @Query("SELECT u FROM User u WHERE u.id = :userid")
    ExtraCompetence findUserById(@Param("userid") Integer id);

}