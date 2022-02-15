package pl.edu.wszib.power.tool.rental.validators;

import pl.edu.wszib.power.tool.rental.exceptions.RegisterException;

public class RegisterValidator {
    public static void validateName(String name) {
        checkValues(name);
    }

    public static void validateSurname(String surname) {
        checkValues(surname);
    }

    public static void validatePasswords(String pass1, String pass2) {
        checkValues2(pass1, pass2);
    }

    private static void checkValues(String value) {
        if(value == null || value.length() <= 1) {
            throw new RegisterException("Incorrect name or surname");
        }
    }

    private static void checkValues2(String value1, String value2) {
        if(value1 == null || !value1.equals(value2)) {
            throw new RegisterException("Incorrect passwords");
        }
    }
}
