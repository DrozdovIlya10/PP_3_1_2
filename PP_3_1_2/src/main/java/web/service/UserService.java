package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void getUserForAdd(User user);
    List<User> listUsers();
    void getIdForDelete(Long id);
    void getIdAndUserForUpdate(long id, User user);
    User getIdForUser(long id);
}
