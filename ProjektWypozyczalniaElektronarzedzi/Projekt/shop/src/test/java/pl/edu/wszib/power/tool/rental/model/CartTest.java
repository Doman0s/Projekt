package pl.edu.wszib.power.tool.rental.model;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.wszib.power.tool.rental.TestUtils;

public class CartTest {

    @Test
    public void threePositionsGetSumTest() {
        Cart cart = new Cart();

        cart.getOrderPositions().add(TestUtils.generateOrderPosition(23.50, 5));
        cart.getOrderPositions().add(TestUtils.generateOrderPosition(44.99, 14));
        cart.getOrderPositions().add(TestUtils.generateOrderPosition(29.99, 1));

        double expectedResult = 777.35;

        double result = cart.getCalculatedSum();

        Assert.assertEquals(expectedResult, result, 0.001);
    }

    @Test
    public void emptyCartGetSumTest() {
        Cart cart = new Cart();

        double expectedResult = 0.0;

        double result = cart.getCalculatedSum();

        Assert.assertEquals(expectedResult, result, 0.001);
    }
}
