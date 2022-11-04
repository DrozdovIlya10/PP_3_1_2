package dao;

import model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    User getUser(long id);
    void delUser(long id);

}