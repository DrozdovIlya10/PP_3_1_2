package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImp implements UserService{

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void getIdForDelete(Long id) {
        userDao.getIdForDelete(id);
    }

    @Transactional
    @Override
    public void getUserForAdd(User user) {
        userDao.getUserForAdd(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public User getIdForUser(long id) {
        return userDao.getIdForUser(id);
    }

    @Transactional
    @Override
    public void getIdAndUserForUpdate(long id, User user) {
        userDao.getIdAndUserForUpdate(id, user);
    }
}
