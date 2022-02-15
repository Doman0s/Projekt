package pl.edu.wszib.power.tool.rental.database;

import pl.edu.wszib.power.tool.rental.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductDAO {
    List<Product> getProducts();
    Optional<Product> getProductById(int productId);
    void updateProduct(Product product);
    void addProduct(Product product);
}
