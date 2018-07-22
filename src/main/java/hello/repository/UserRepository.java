package hello.repository;

import hello.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by serg on 16-Jul-18.
 */
public interface UserRepository extends CrudRepository<User, Integer>{
    void delete(User user);

    List<User> findAll();

    @Override
    Optional<User> findById(Integer integer);

    //User findOne(Integer id);

    User save(User user);
}
