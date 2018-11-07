package hva.ewa.Entrepreneurship.repository;

import hva.ewa.Entrepreneurship.model.Result;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResultRepository extends CrudRepository<Result, Integer> {

//    @Query("SELECT user_id, competence_id, score FROM Result")
//    List<Result> getResults(Integer user_id, Integer competence_id, Double score);
}
