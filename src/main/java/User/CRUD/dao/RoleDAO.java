package User.CRUD.dao;

import User.CRUD.model.Role;

import java.util.List;

public interface RoleDAO {

    Role getRoleByName(String name);

    void addRole(Role role);

    Role getRoleById(Long id);

    List<Role> allRoles();
}
