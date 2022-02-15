package pl.edu.wszib.power.tool.rental.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.power.tool.rental.model.Cart;
import pl.edu.wszib.power.tool.rental.model.User;

@Component
@SessionScope
public class Session {
    final private Cart cart = new Cart();
    private User user = null;

    public boolean isLogged() {
        return this.user != null;
    }

    public String whoIsLogged() {
        if(isLogged()) {
            return this.user.getLogin();
        }
        return "nobody";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }
}
