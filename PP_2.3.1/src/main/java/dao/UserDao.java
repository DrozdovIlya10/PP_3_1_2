package dao;

import model.User;

public interface UserDao {
    User getUser ();
    void addUser (User user);
    void delUser (User user);
    void editUser (User user);
}
