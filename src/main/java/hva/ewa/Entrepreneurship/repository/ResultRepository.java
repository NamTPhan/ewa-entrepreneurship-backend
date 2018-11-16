package hva.ewa.Entrepreneurship.repository;

import hva.ewa.Entrepreneurship.model.Result;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Integer> {

    @Query("SELECT CASE WHEN count(u) <= 0 THEN TRUE ELSE FALSE END FROM Result u WHERE u.user_id = ?1")
    boolean doesUserHasResult(Integer user_id);

    @Query("SELECT user_id, competence_id, score FROM Result WHERE user_id = :user_id ORDER BY competence_id ASC")
    List<Result> getAllResults(@Param("user_id") Integer id);

    @Query("SELECT user_id, competence_id, score FROM Result WHERE user_id = :user_id AND competence_id > 3 ORDER BY score DESC")
    List<Result> getOrderedScores(@Param("user_id") Integer id);
}
