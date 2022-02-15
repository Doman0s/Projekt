package pl.edu.wszib.power.tool.rental.service;

import pl.edu.wszib.power.tool.rental.model.Ruser;
import pl.edu.wszib.power.tool.rental.model.User;

public interface IAuthService {
    void login(String login, String password);
    void register(Ruser registerUser);
    void modifyUser(User user);
    void changePassword(Ruser ruser);
}
