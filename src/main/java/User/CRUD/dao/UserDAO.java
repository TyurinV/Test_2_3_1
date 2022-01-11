package User.CRUD.dao;

import User.CRUD.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface UserDAO {
    List<User> allUsers();
    void add(User user);
    void remove(User user);
    void edit(User user);
    User getById(int id);
    User getUserByName(String userName);
}
