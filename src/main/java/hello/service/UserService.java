package hello.service;

import hello.model.User;

import java.util.List;

/**
 * Created by serg on 16-Jul-18.
 */
public interface UserService {
    User create(User user);

    User delete(Integer id);

    List<User> findAll();

    User findById(Integer id);

    User update(User user);
}
