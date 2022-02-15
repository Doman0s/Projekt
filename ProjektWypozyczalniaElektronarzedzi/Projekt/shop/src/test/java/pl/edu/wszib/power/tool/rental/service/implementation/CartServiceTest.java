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
import pl.edu.wszib.power.tool.rental.service.ICartService;
import pl.edu.wszib.power.tool.rental.session.Session;

import javax.annotation.Resource;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class CartServiceTest {
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
    public void AddToCartCorrectTest() {
        Mockito.when(this.productDAO.getProductById(1)).thenReturn(Optional.of(TestUtils.generateProduct()));
        int id = 1;
        int time = 5;

        this.cartService.addToCart(id, time);
        Assert.assertFalse(this.session.getCart().getOrderPositions().isEmpty());
    }

    @Test
    public void AddToCartIncorrectTest() {
        Mockito.when(this.productDAO.getProductById(1)).thenReturn(Optional.of(TestUtils.generateProduct()));
        int id = 2;
        int time = 5;

        this.cartService.addToCart(id, time);
        Assert.assertTrue(this.session.getCart().getOrderPositions().isEmpty());
    }

    @Test
    public void deleteFromCartCorrectTest() {
        Mockito.when(this.productDAO.getProductById(1)).thenReturn(Optional.of(TestUtils.generateProduct()));
        int id = 1;
        int time = 5;
        this.cartService.addToCart(id, time);

        this.cartService.deleteFromCart(this.session.getCart().getOrderPositions().get(0).getCartId());
        Assert.assertTrue(this.session.getCart().getOrderPositions().isEmpty());
    }

    @Test
    public void deleteFromCartIncorrectTest() {
        Mockito.when(this.productDAO.getProductById(1)).thenReturn(Optional.of(TestUtils.generateProduct()));
        int id = 1;
        int time = 5;
        this.cartService.addToCart(id, time);

        this.cartService.deleteFromCart(this.session.getCart().getOrderPositions().get(0).getCartId() + 1);
        Assert.assertFalse(this.session.getCart().getOrderPositions().isEmpty());
    }
}
