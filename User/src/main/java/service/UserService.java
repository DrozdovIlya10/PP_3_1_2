package service;

import model.User;

public interface UserService {
    User getUser ();
    void addUser (User user);
    void delUser (User user);
    void editUser (User user);
}
