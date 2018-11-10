package hva.ewa.Entrepreneurship.repository;

import hva.ewa.Entrepreneurship.model.Result;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Integer> {

    @Query("SELECT user_id, competence_id, score FROM Result WHERE user_id = 1 ORDER BY competence_id ASC")
    List<Result> getAllResults(Integer user_id, Integer competence_id, Double score);

    @Query("SELECT user_id, competence_id, score FROM Result WHERE user_id = 1 AND competence_id > 3 ORDER BY score DESC")
    List<Result> getOrderedScores(Integer user_id, Integer competence_id, Double score);
}
