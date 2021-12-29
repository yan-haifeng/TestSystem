package controller;

import service.UserService;

public class UserController {
    private UserService userService = new UserService();

    public boolean login(String username,String password){
        return userService.login(username,password);
    }
}
