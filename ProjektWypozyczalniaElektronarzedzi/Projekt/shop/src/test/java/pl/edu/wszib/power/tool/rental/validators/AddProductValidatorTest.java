package pl.edu.wszib.power.tool.rental.validators;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.wszib.power.tool.rental.exceptions.AddProductException;

public class AddProductValidatorTest {
    @Test
    public void validateIncorrectNameTest() {
        AddProductValidator addProductValidator = new AddProductValidator();

        String name = "a";
        String expectedResult = "Incorrect name or description";

        try {
            addProductValidator.validateName(name);
        } catch (AddProductException e) {
            Assert.assertEquals(expectedResult, e.getInfo());
        }
    }

    @Test
    public void validateCorrectNameTest() {
        AddProductValidator addProductValidator = new AddProductValidator();

        String name = "wiertara";

        try {
            addProductValidator.validateName(name);
        } catch (AddProductException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateIncorrectDescriptionTest() {
        AddProductValidator addProductValidator = new AddProductValidator();

        String description = "a";
        String expectedResult = "Incorrect name or description";

        try {
            addProductValidator.validateDescription(description);
        } catch (AddProductException e) {
            Assert.assertEquals(expectedResult, e.getInfo());
        }
    }

    @Test
    public void validateCorrectDescriptionTest() {
        AddProductValidator addProductValidator = new AddProductValidator();

        String description = "opis";

        try {
            addProductValidator.validateDescription(description);
        } catch (AddProductException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateIncorrectPriceTest() {
        AddProductValidator addProductValidator = new AddProductValidator();

        double price = 0.5;
        String expectedResult = "Incorrect price";

        try {
            addProductValidator.validatePrice(price);
        } catch (AddProductException e) {
            Assert.assertEquals(expectedResult, e.getInfo());
        }
    }

    @Test
    public void validateCorrectPriceTest() {
        AddProductValidator addProductValidator = new AddProductValidator();

        double price = 29.99;

        try {
            addProductValidator.validatePrice(price);
        } catch (AddProductException e) {
            Assert.fail();
        }
    }

    @Test
    public void validateIncorrectQuantityTest() {
        AddProductValidator addProductValidator = new AddProductValidator();

        int quantity = 0;
        String expectedResult = "Incorrect quantity";

        try {
            addProductValidator.validateQuantity(quantity);
        } catch (AddProductException e) {
            Assert.assertEquals(expectedResult, e.getInfo());
        }
    }

    @Test
    public void validateCorrectQuantityTest() {
        AddProductValidator addProductValidator = new AddProductValidator();

        int quantity = 25;

        try {
            addProductValidator.validateQuantity(quantity);
        } catch (AddProductException e) {
            Assert.fail();
        }
    }
}
