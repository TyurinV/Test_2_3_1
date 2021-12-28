package User.CRUD.service;

import User.CRUD.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> allUsers();
    void add(User user);
    void remove(User user);
    void edit(User user);
    User getById(int id);
}
