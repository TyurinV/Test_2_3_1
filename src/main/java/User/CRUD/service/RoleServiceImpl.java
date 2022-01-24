package User.CRUD.service;

import User.CRUD.dao.RoleDAO;
import User.CRUD.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRoleByName(String name) {
        return this.roleDAO.getRoleByName(name);
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRoleById(Long id) {
        return this.roleDAO.getRoleById(id);
    }

    @Override
    @Transactional
    public List<Role> allRoles() {
        return this.roleDAO.allRoles();
    }
}
