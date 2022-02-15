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
import pl.edu.wszib.power.tool.rental.exceptions.AuthException;
import pl.edu.wszib.power.tool.rental.service.IAuthService;
import pl.edu.wszib.power.tool.rental.session.Session;

import javax.annotation.Resource;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class AuthServiceTest {
    @Autowired
    IAuthService authService;

    @Resource
    Session session;

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IProductDAO productDAO;

    @MockBean
    IOrderDAO orderDAO;

    @Test
    public void correctLoginTest() {
        Mockito.when(this.userDAO.getUserByLogin("admin")).thenReturn(TestUtils.generateSecondUser());
        String login = "admin";
        String password = "admin";

        this.authService.login(login, password);
        Assert.assertTrue(this.session.isLogged());
    }

    @Test
    public void incorrectLoginTest() {
        Mockito.when(this.userDAO.getUserByLogin("admin342")).thenReturn(Optional.empty());
        String login = "admin342";
        String password = "admin123123";

        this.authService.login(login, password);
        Assert.assertFalse(this.session.isLogged());
    }

    @Test
    public void correctRegisterTest() {
        String expectedResult = "Login is already used";

        try {
            this.authService.register(TestUtils.generateRuser());
        } catch (AuthException e) {
            Assert.assertEquals(expectedResult, e.getInfo());
        }
    }

    @Test
    public void IncorrectRegisterTest() {
        try {
            this.authService.register(TestUtils.generateRuser());
        } catch (AuthException e) {
            Assert.fail();
        }
    }
}
