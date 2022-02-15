package pl.edu.wszib.power.tool.rental.database;

import pl.edu.wszib.power.tool.rental.model.Order;

import java.util.List;

public interface IOrderDAO {
    void addOrder(Order order);
    List<Order> getOrdersByUserId(int userId);
}
