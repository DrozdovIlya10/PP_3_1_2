package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void getUserForAdd(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void getIdForDelete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        List<User> list = entityManager.createQuery("select user from User user").getResultList();
        return list;
    }

    @Override
    public User getIdForUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.detach(user);
        return user;
    }

    @Override
    public void getIdAndUserForUpdate(long id, User user2) {
        entityManager.merge(user2);
    }

}

