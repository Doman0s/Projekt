package pl.edu.wszib.power.tool.rental.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<OrderPosition> orderPositions = new ArrayList<>();

    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public double getCalculatedSum() {
        double result = 0.0;
        for(OrderPosition orderPosition : this.orderPositions) {
            result += orderPosition.getDays() * orderPosition.getProduct().getPrice();
        }
        return Math.round(result*100)/100.0;
    }

    public void clearOrders() {
        this.orderPositions = new ArrayList<>();
    }
}
