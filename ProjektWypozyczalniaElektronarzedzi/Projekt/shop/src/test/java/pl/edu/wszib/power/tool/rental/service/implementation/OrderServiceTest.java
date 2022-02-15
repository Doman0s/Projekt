package pl.edu.wszib.power.tool.rental.service.implementation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.power.tool.rental.TestUtils;
import pl.edu.wszib.power.tool.rental.configuration.TestConfiguration;
import pl.edu.wszib.power.tool.rental.database.IOrderDAO;
import pl.edu.wszib.power.tool.rental.database.IProductDAO;
import pl.edu.wszib.power.tool.rental.database.IUserDAO;
import pl.edu.wszib.power.tool.rental.model.Order;
import pl.edu.wszib.power.tool.rental.service.ICartService;
import pl.edu.wszib.power.tool.rental.service.IOrderService;
import pl.edu.wszib.power.tool.rental.session.Session;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class OrderServiceTest {
    @Autowired
    IOrderService orderService;

    @Autowired
    ICartService cartService;

    @Resource
    Session session;

    @MockBean
    IProductDAO productDAO;

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IOrderDAO orderDAO;

    @Test
    public void getLoggedUserOrdersCorrectTest() {
        Mockito.when(this.productDAO.getProductById(1)).thenReturn(Optional.of(TestUtils.generateProduct()));
        List<Order> orders = new ArrayList<>();
        orders.add(TestUtils.generateOrder());
        orders.add(TestUtils.generateOrder());

        this.session.setUser(TestUtils.generateUser());

        int userID = 1;

        Mockito.when(this.orderDAO.getOrdersByUserId(userID)).thenReturn(orders);
        Assert.assertFalse(this.orderService.getLoggedUserOrders().isEmpty());
    }

    @Test
    public void getLoggedUserOrdersIncorrectTest() {
        List<Order> orders = new ArrayList<>();
        orders.add(TestUtils.generateOrder());
        orders.add(TestUtils.generateOrder());

        this.session.setUser(TestUtils.generateUser());

        int userID = 2;

        Mockito.when(this.orderDAO.getOrdersByUserId(userID)).thenReturn(orders);
        Assert.assertTrue(this.orderService.getLoggedUserOrders().isEmpty());
    }

    @Test
    public void ConfirmOrderCorrectTest() {
        Mockito.when(this.productDAO.getProductById(1)).thenReturn(Optional.of(TestUtils.generateProduct()));
        this.cartService.addToCart(1, 5);

        this.orderService.confirmOrder();
        Assert.assertTrue(this.session.getCart().getOrderPositions().isEmpty());
    }
}
