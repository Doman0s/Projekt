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
import pl.edu.wszib.power.tool.rental.model.Product;
import pl.edu.wszib.power.tool.rental.service.IProductService;
import pl.edu.wszib.power.tool.rental.session.Session;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class ProductServiceTest {
    @Autowired
    IProductService productService;

    @Resource
    Session session;

    @MockBean
    IProductDAO productDAO;

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IOrderDAO orderDAO;

    @Test
    public void getAllProductsCorrectTest() {
        Mockito.when(this.productDAO.getProducts()).thenReturn(TestUtils.generateProductsList());

        List<Product> products = new ArrayList<>();
        products = this.productService.getAllProducts();

        Assert.assertFalse(products.isEmpty());
    }

    @Test
    public void getAllProductsIncorrectTest() {
        List<Product> products = new ArrayList<>();
        products = this.productService.getAllProducts();

        Assert.assertTrue(products.isEmpty());
    }

    @Test
    public void getProductByIdCorrectTest() {
        Mockito.when(this.productDAO.getProductById(1)).thenReturn(Optional.of(TestUtils.generateProduct()));

        int id = 1;

        Assert.assertNotNull(this.productService.getProductById(id));
    }

    @Test
    public void getProductByIdIncorrectTest() {
        Mockito.when(this.productDAO.getProductById(1)).thenReturn(Optional.of(TestUtils.generateProduct()));

        int id = 2;

        Assert.assertNotNull(this.productService.getProductById(id));
    }
}