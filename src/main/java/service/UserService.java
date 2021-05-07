package service;

import dao.UserDAOImpl;
import model.Auto;
import model.User;

import java.util.List;

public class UserService {

    private final UserDAOImpl userDAO = new UserDAOImpl();

    public User findById(int id) {
        return userDAO.findById(id);
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

    public Auto getAutoById(int id) {
        return userDAO.getAutoById(id);
    }

    public List<User> getAll() {
        return userDAO.getAll();
    }

    public List<Auto> getAllAutoByUserId(int id) {
        return userDAO.getAllAutoByUserId(id);
    }
}
