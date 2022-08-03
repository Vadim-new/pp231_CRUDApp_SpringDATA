package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.getAllUsers();
    }

    @Override
    public User findOne(int id) {
        return userDao.getById(id);
    }

    @Override
    public void save(User user) {
        userDao.add(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        userDao.edit(id, updatedUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}