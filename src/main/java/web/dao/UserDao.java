package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void add(User user);

    void delete(int id);

    void edit(int id, User user);

    User getById(int id);
}