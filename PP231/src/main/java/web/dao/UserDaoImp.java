package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;


import javax.persistence.*;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void add(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        List<User> list = entityManager.createQuery("select user from User user").getResultList();
        return list;
    }
    @Transactional
    @Override
    public User showUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.detach(user);
        return user;
    }

    @Transactional
    @Override
    public void update(long id, User user2) {
        User user = showUser(id);
        //entityManager.detach(user);
        user.setFirstName(user2.getFirstName());
        user.setLastName(user2.getLastName());
        user.setEmail(user2.getEmail());
        entityManager.merge(user);
        entityManager.flush();
    }

}

