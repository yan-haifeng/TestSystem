package controller;

import beans.User;
import service.impl.UserServiceImpl;

public class UserController {
    private UserServiceImpl userService = new UserServiceImpl();

    public boolean login(String username,String password){
        return userService.login(username,password);
    }
    public User getUserById(String username){
        return userService.getUserById(username);
    }
}
