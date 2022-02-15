package pl.edu.wszib.power.tool.rental.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "torderposition")
public class OrderPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cartId;
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
    private int days;
    private LocalDateTime dateOfReturn;

    public OrderPosition(int id, int cartId, Product product, int days) {
        this.id = id;
        this.cartId = cartId;
        this.product = product;
        this.days = days;
        this.dateOfReturn = LocalDateTime.now().plusDays(days);
    }

    public OrderPosition() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartId() {
        return cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public LocalDateTime getDateOfReturn() {
        return dateOfReturn;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setDateOfReturn(LocalDateTime dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
