package hva.ewa.Entrepreneurship.repository;

import hva.ewa.Entrepreneurship.model.ExtraCompetence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExtraCompetenceRepository extends CrudRepository<ExtraCompetence, Integer> {

}