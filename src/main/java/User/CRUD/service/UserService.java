package User.CRUD.service;

import User.CRUD.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void add(User user);
    void remove(Long id);
    void edit(User user);
    User getById(Long id);
}
