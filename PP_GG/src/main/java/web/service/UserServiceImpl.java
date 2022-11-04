package web.service;

import web.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static final List<User> carList = new ArrayList<>();

    static {
        carList.add(new User());
        carList.add(new User());
        carList.add(new User());
        carList.add(new User());
        carList.add(new User());
    }
    @Override
    public List<User> getUser() {
        return carList;
    }
}
