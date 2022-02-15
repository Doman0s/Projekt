package pl.edu.wszib.power.tool.rental.validators;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.wszib.power.tool.rental.exceptions.AuthException;

public class LoginValidatorTest {
    @Test
    public void validateIncorrectLoginTest() {
        LoginValidator loginValidator = new LoginValidator();

        String login = "a";
        String expectedResult = "Incorrect login";

        try {
             loginValidator.validateLogin(login);
        } catch (AuthException e) {
            Assert.assertEquals(expectedResult, e.getInfo());
        }
    }

    @Test
    public void validateCorrectLoginTest() {
        LoginValidator loginValidator = new LoginValidator();

        String login = "admin";

        try {
            loginValidator.validateLogin(login);
        } catch (AuthException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateIncorrectPasswordTest() {
        LoginValidator loginValidator = new LoginValidator();

        String password = "a";
        String expectedResult = "Incorrect password";

        try {
            loginValidator.validatePassword(password);
        } catch (AuthException e) {
            Assert.assertEquals(expectedResult, e.getInfo());
        }
    }

    @Test
    public void validateCorrectPasswordTest() {
        LoginValidator loginValidator = new LoginValidator();

        String password = "admin";

        try {
            loginValidator.validatePassword(password);
        } catch (AuthException e) {
            Assert.fail();
        }
    }
}
