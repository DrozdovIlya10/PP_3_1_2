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
    public void setUserForSave(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void setIdForDelete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getListUsers() {
        List<User> list = entityManager.createQuery("select user from User user").getResultList();
        return list;
    }

    @Override
    public User getUserById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.detach(user);
        return user;
    }

    @Override
    public void setIdAndUserForEdit(long id, User user2) {
        entityManager.merge(user2);
    }

}

