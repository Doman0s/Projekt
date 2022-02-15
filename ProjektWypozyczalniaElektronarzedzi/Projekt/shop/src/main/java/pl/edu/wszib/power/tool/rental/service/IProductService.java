package pl.edu.wszib.power.tool.rental.service;

import pl.edu.wszib.power.tool.rental.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAllProducts();
    void add(Product product);
    void modify(Product product);
    Optional<Product> getProductById(int productId);
}
