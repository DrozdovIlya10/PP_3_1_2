package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void setIdForDelete(Long id) {
        userDao.setIdForDelete(id);
    }

    @Transactional
    @Override
    public void setUserForSave(User user) {
        userDao.setUserForSave(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getListUsers() {
        return userDao.getListUsers();
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void setIdAndUserForEdit(long id, User user) {
        userDao.setIdAndUserForEdit(id, user);
    }
}
