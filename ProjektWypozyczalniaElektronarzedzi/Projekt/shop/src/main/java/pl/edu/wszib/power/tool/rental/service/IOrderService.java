package pl.edu.wszib.power.tool.rental.service;

import pl.edu.wszib.power.tool.rental.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getLoggedUserOrders();
    void confirmOrder();
}
