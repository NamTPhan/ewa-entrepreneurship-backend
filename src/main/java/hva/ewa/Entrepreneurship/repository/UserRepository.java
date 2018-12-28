package hva.ewa.Entrepreneurship.repository;
import hva.ewa.Entrepreneurship.model.Result;
import hva.ewa.Entrepreneurship.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT email, password, role FROM User")
    List<User> findAllUsers(String email, String password, String role);

    @Query("SELECT CASE WHEN count(u) > 0 THEN TRUE ELSE FALSE END FROM User u WHERE u.email = ?1")
    boolean doesUserExist(String email);

    @Query("SELECT email FROM User")
    List<User> findAllEmail(String email);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByUserEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id = :userid")
    User findUserById(@Param("userid") Integer id);

    @Modifying
    @Query("UPDATE User u SET u.first_name = ?1, u.last_name = ?2, u.email = ?3 WHERE u.id = :id")
    User updateUser(String first_name, String last_name, String email, @PathVariable("userid") Integer id);

    @Query("SELECT id, email, first_name, last_name, role, teacher FROM User")
    List<User> listAllUsers(Integer id, String email, String first_name, String last_name, String role, String teacher);
}
