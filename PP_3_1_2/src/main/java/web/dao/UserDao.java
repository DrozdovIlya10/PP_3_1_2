package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void setUserForSave(User user);

    List<User> getListUsers();

    void setIdForDelete(Long id);

    User getUserById(long id);

    void setIdAndUserForEdit(long id, User user);
}
