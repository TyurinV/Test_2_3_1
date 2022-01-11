package User.CRUD.dao;

import User.CRUD.model.User;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> allUsers() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void remove(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    @Override
    public void edit(User user) {
        em.merge(user);

    }

    @Override
    public User getById(int id) {
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