package pl.edu.wszib.power.tool.rental.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.power.tool.rental.database.IProductDAO;
import pl.edu.wszib.power.tool.rental.model.OrderPosition;
import pl.edu.wszib.power.tool.rental.model.Product;
import pl.edu.wszib.power.tool.rental.service.ICartService;
import pl.edu.wszib.power.tool.rental.session.Session;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.Random;

@Service
public class CartService implements ICartService {
    @Autowired
    IProductDAO productDAO;

    @Resource
    Session session;

    public void addToCart(int productId, int time) {
        Optional<Product> product = this.productDAO.getProductById(productId);

        if(product.isEmpty()) {
            return;
        }

        Product prod = product.get();
        if(prod.getQuantity() <= 0) {
            return;
        }

        int counter = 0;
        for(OrderPosition orderPosition : this.session
                .getCart().getOrderPositions()) {
            if(orderPosition.getProduct().getId() == productId) {
                counter++;
                if(!(prod.getQuantity() > counter)) {
                    return;
                }
            }
        }

        Random r = new Random();
        OrderPosition orderPosition = new OrderPosition(0, r.nextInt(10000000), prod, time);
        this.session.getCart().getOrderPositions().add(orderPosition);
    }

    public void deleteFromCart(int cartProductId) {
        for(OrderPosition orderPosition : this.session
                .getCart().getOrderPositions()) {
            if(orderPosition.getCartId() == cartProductId) {
                session.getCart().getOrderPositions().remove(orderPosition);
                return;
            }
        }
    }
}
