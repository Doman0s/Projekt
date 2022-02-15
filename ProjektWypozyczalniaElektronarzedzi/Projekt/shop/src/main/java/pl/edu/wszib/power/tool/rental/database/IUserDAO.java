package pl.edu.wszib.power.tool.rental.database;

import pl.edu.wszib.power.tool.rental.model.User;

import java.util.Optional;

public interface IUserDAO {
    Optional<User> getUserByLogin(String login);
    void addUser(User user);
    Optional<User> getUserById(int id);
    void updateUser(User user);
}
