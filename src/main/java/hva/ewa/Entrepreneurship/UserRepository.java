package hva.ewa.Entrepreneurship;
import hva.ewa.Entrepreneurship.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT email, password, role FROM User")
    List<User> findAllUsers(String email, String password, String role);

}
