package controller;

import beans.User;
import service.UserService;

public class UserController {
    private UserService userService = new UserService();

    public boolean login(String username,String password){
        return userService.login(username,password);
    }
    public User getUserById(String username){
        return userService.getUserById(username);
    }
}
