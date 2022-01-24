package User.CRUD.dao;

import User.CRUD.model.Role;
import User.CRUD.model.User;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        List<User> one = em.createQuery("SELECT u FROM User u JOIN FETCH u.roles ", User.class).getResultList();
        return one;
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void remove(Long id) {
        em.remove(em.find(User.class, id));
    }

    @Override
    public void edit(User user) {
        em.merge(user);

    }

    @Override
    public User getById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public User getUserByName(String userName) {
        return em
                .createQuery("select us from User us where us.firstName = :username", User.class)
                .setParameter("username", userName)
                .getSingleResult();
    }
}