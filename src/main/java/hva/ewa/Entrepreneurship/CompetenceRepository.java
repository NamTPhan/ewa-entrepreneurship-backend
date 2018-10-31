package hva.ewa.Entrepreneurship;
import hva.ewa.Entrepreneurship.model.Competence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface CompetenceRepository extends CrudRepository<Competence, Integer> {

    @Query("SELECT competence_id, competence FROM Competence")
    List<Competence> findAllCompetences(Integer competence_id, String competence);
}
