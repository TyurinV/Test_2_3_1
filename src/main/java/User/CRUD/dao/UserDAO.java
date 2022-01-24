package User.CRUD.dao;

import User.CRUD.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface UserDAO {
    List<User> getAllUsers();
    void add(User user);
    void remove(Long id);
    void edit(User user);
    User getById(Long id);
    User getUserByName(String userName);
}
