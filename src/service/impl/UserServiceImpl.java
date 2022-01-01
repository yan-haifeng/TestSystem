package service.impl;

import beans.User;
import dao.UserDao;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDao();

    public boolean login(String username,String password){
        User user = userDao.getUserById(username);
        if(userDao.getUserById(username) != null){
            return password.equals(user.getPassword());
        }
        return false;
    }

    public User getUserById(String username){
        return userDao.getUserById(username);
    }
}
