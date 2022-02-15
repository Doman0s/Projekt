package pl.edu.wszib.power.tool.rental.validators;

import pl.edu.wszib.power.tool.rental.exceptions.AuthException;

public class LoginValidator {
    public static void validateLogin(String login) {
        if(login == null || login.length() <= 1) {
            throw new AuthException("Incorrect login");
        }
    }

    public static void validatePassword(String password) {
        if(password == null || password.length() <= 1) {
            throw new AuthException("Incorrect password");
        }
    }
}
