package web.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = em.createQuery("select u from User u", User.class).getResultList();
        return userList;
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(User.class, id));
    }

    @Override
    public void edit(int id, User user) {
        em.merge(user);
    }

    @Override
    public User getById(int id) {
        return em.find(User.class, id);
    }
}