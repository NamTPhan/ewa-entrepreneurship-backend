package hva.ewa.Entrepreneurship.repository;
import hva.ewa.Entrepreneurship.model.Question;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface QuestionRepository extends CrudRepository<Question, Integer>{

    @Query(nativeQuery = true, value = "SELECT question_id, description_text, competence_id FROM Question LIMIT 20")
    List<Question> findMaxTestQuestions(Integer question_id, String description_text, Integer competence_id);

    @Query("SELECT question_id, description_text, competence_id FROM Question")
    List<Question> findAllQuestions(Integer question_id, String description_text, Integer competence_id);

    @Transactional
    @Modifying
    @Query("UPDATE Question q SET q.competence_id = ?2 WHERE q.question_id = ?1")
    Integer updateQuestion(@PathVariable("question_id")Integer question_id, Integer competence_id);

    @Query("SELECT q FROM Question q WHERE q.question_id = :question_id")
    Question findQuestionById(@Param("question_id") Integer question_id);

}
