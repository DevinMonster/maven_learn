package com.devin.spring.demo;

import com.devin.proxy.User;
import com.devin.proxy.UserService;

public class UserServiceImpl implements UserService {
//    private final UserDAO userDAO = (UserDAO) BeanFactory.getBean("userDAO");
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void register(User user) {
        userDAO.save(user);
    }

    public boolean login(String username, String password) {
        userDAO.queryUserByUserNameAndPassword(username, password);
        return true;
    }
}
