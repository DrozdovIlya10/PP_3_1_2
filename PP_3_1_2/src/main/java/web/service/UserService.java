package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void setUserForSave(User user);

    List<User> getListUsers();

    void setIdForDelete(Long id);

    void setIdAndUserForEdit(long id, User user);

    User getUserById(long id);
}
