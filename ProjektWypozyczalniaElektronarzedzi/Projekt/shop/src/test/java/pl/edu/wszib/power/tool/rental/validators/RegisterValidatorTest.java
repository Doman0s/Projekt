package pl.edu.wszib.power.tool.rental.validators;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.wszib.power.tool.rental.exceptions.RegisterException;

public class RegisterValidatorTest {
    @Test
    public void validateIncorrectNameTest() {
        RegisterValidator registerValidator = new RegisterValidator();

        String name = "a";
        String expectedResult = "Incorrect name or surname";

        try {
            registerValidator.validateName(name);
        } catch (RegisterException e) {
            Assert.assertEquals(expectedResult, e.getInfo());
        }
    }

    @Test
    public void validateCorrectNameTest() {
        RegisterValidator registerValidator = new RegisterValidator();

        String name = "Jan";

        try {
            registerValidator.validateName(name);
        } catch (RegisterException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateIncorrectSurnameTest() {
        RegisterValidator registerValidator = new RegisterValidator();

        String surname = "a";
        String expectedResult = "Incorrect name or surname";

        try {
            registerValidator.validateSurname(surname);
        } catch (RegisterException e) {
            Assert.assertEquals(expectedResult, e.getInfo());
        }
    }

    @Test
    public void validateCorrectSurameTest() {
        RegisterValidator registerValidator = new RegisterValidator();

        String surname = "Kowalski";

        try {
            registerValidator.validateSurname(surname);
        } catch (RegisterException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateIncorrectPasswordsTest() {
        RegisterValidator registerValidator = new RegisterValidator();

        String pass1 = "def";
        String pass2 = "abc";
        String expectedResult = "Incorrect passwords";

        try {
            registerValidator.validatePasswords(pass1, pass2);
        } catch (RegisterException e) {
            Assert.assertEquals(expectedResult, e.getInfo());
        }
    }

    @Test
    public void validateCorrectPasswordsTest() {
        RegisterValidator registerValidator = new RegisterValidator();

        String pass1 = "abc";
        String pass2 = "abc";

        try {
            registerValidator.validatePasswords(pass1, pass2);
        } catch (RegisterException e) {
            Assert.fail();
        }
    }
}
