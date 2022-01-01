package service;

import beans.User;

public interface UserService {
    public boolean login(String username,String password);
    public User getUserById(String username);
}
