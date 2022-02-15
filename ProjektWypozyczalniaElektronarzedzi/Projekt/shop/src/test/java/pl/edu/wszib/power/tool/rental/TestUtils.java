package pl.edu.wszib.power.tool.rental;

import pl.edu.wszib.power.tool.rental.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class TestUtils {
    public static OrderPosition generateOrderPosition(double price, int days) {
        Product product = new Product();
        product.setId(1);
        product.setName("wfdsfdsfdsfds");
        product.setDescription("fdsfsd sdfdsf dsfdsfsd");
        product.setQuantity(5);
        product.setPrice(price);

        OrderPosition orderPosition = new OrderPosition();
        orderPosition.setDays(days);
        orderPosition.setProduct(product);

        return orderPosition;
    }

    public static Product generateProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("wfdsfdsfdsfds");
        product.setDescription("fdsfsd sdfdsf dsfdsfsd");
        product.setQuantity(5);
        product.setPrice(9.99);

        return product;
    }

    public static List<Product> generateProductsList() {
        Product p1 = new Product();
        Product p2 = new Product();

        p1 = generateProduct();
        p2 = generateProduct();

        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);

        return products;
    }

    public static User generateUser() {
        User user = new User();
        user.setId(1);
        user.setName("asdsads");
        user.setSurname("swwww");
        user.setLogin("aaasssddd");
        user.setPassword("jhgfiwianx");

        return user;
    }

    public static Optional<User> generateSecondUser() {
        User user = new User();
        user.setLogin("admin");
        user.setName("asdsad");
        user.setSurname("asfdsaf");
        user.setPassword("21232f297a57a5a743894a0e4a801fc3");
        user.setId(1);

        return Optional.of(user);
    }

    public static Ruser generateRuser() {
        Ruser ruser = new Ruser();
        ruser.setLogin("admin");
        ruser.setName("asdsad");
        ruser.setSurname("asfdsaf");
        ruser.setPassword("admin");
        ruser.setSecondPassword("admin");
        ruser.setId(1);

        return ruser;
    }

    public static Order generateOrder() {
        Order order = new Order();
        order.setId(1);
        order.setPrice(14.99);
        order.setUser(generateUser());
        order.setOrderPositions(Set.of(generateOrderPosition(14.99, 1)));
        order.setDate(LocalDateTime.now());

        return order;
    }
}
