package service;

import beans.User;
import dao.UserDao;

public class UserService {
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
