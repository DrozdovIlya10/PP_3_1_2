package dao;

import model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();

    }
    @Override
    public List<User> userCar(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery
                (String.format("SELECT user FROM Car WHERE model = '%s' and series = '%d'", model, series));
        return query.getResultList();
    }



}