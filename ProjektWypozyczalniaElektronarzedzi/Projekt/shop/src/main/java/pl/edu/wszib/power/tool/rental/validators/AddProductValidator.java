package pl.edu.wszib.power.tool.rental.validators;

import pl.edu.wszib.power.tool.rental.exceptions.AddProductException;

public class AddProductValidator {
    public static void validateName(String name) {
        checkString(name);
    }

    public static void validateDescription(String description) {
        checkString(description);
    }

    public static void validatePrice(double price) {
        checkDouble(price);
    }

    public static void validateQuantity(int quantity) {
        checkInt(quantity);
    }

    private static void checkString(String value) {
        if(value == null || value.length() <= 1) {
            throw new AddProductException("Incorrect name or description");
        }
    }

    private static void checkDouble(double value) {
        if(value < 1 || value > 9999) {
            throw new AddProductException("Incorrect price");
        }
    }

    private static void checkInt(int value) {
        if(value < 1 || value > 999) {
            throw new AddProductException("Incorrect quantity");
        }
    }
}
