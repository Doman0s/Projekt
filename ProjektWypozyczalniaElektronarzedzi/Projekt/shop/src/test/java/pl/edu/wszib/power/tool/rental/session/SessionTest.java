package pl.edu.wszib.power.tool.rental.session;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.wszib.power.tool.rental.TestUtils;
import pl.edu.wszib.power.tool.rental.model.User;

public class SessionTest {
    @Test
    public void isLoggedTrueTest() {
        Session session = new Session();
        User user = TestUtils.generateUser();

        session.setUser(user);

        boolean result = session.isLogged();

        Assert.assertTrue(session.isLogged());
    }

    @Test
    public void isLoggedFalseTest() {
        Session session = new Session();

        boolean result = session.isLogged();

        Assert.assertFalse(session.isLogged());
    }

    @Test
    public void whoIsLoggedTrueTest() {
        Session session = new Session();
        User user = TestUtils.generateUser();

        session.setUser(user);

        String result = session.whoIsLogged();

        Assert.assertEquals("aaasssddd", result);
    }

    @Test
    public void whoIsLoggedFalseTest() {
        Session session = new Session();

        String result = session.whoIsLogged();

        Assert.assertEquals("nobody", result);
    }
}
