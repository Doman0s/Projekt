package pl.edu.wszib.power.tool.rental.model;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.wszib.power.tool.rental.TestUtils;

import java.util.HashSet;
import java.util.Set;

public class OrderTest {

    @Test
    public void constructOrderWithTwoPositionsTest() {
        Set<OrderPosition> orderPositionSet = new HashSet<>();
        orderPositionSet.add(TestUtils.generateOrderPosition(12.49, 5));
        orderPositionSet.add(TestUtils.generateOrderPosition(8.99, 14));

        Order order = new Order(TestUtils.generateUser(), orderPositionSet);

        double expectedResult = 188.31;

        Assert.assertEquals(expectedResult, order.getPrice(), 0.001);
    }

    @Test
    public void constructOrderWithoutPositionsTest() {
        Set<OrderPosition> orderPositionSet = new HashSet<>();

        Order order = new Order(TestUtils.generateUser(), orderPositionSet);

        double expectedResult = 0.0;

        Assert.assertEquals(expectedResult, order.getPrice(), 0.001);
    }
}
