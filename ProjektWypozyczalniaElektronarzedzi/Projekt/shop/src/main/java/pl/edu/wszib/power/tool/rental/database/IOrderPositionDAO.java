package pl.edu.wszib.power.tool.rental.database;

import pl.edu.wszib.power.tool.rental.model.OrderPosition;

import java.util.List;

public interface IOrderPositionDAO {
    void addOrderPosition(OrderPosition orderPosition, int orderId);
    List<OrderPosition> getOrderPositionsByOrderId(int orderId);
}
