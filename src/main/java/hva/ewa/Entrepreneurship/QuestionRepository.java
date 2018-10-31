package hva.ewa.Entrepreneurship;
import hva.ewa.Entrepreneurship.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface QuestionRepository extends CrudRepository<Question, Integer>{

    @Query("SELECT question_id, descriptiontext, competence_id FROM Question")
    List<Question> findAllQuestions(Integer question_id, String descriptiontext, Integer competence_id);
}
