package pl.edu.wszib.power.tool.rental.service;

public interface ICartService {
    void addToCart(int productId, int time);
    void deleteFromCart(int productId);
}
