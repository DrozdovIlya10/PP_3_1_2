package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void getUserForAdd(User user);
    List<User> listUsers();
    void getIdForDelete(Long id);
    User getIdForUser(long id);
    void getIdAndUserForUpdate(long id, User user);
}
