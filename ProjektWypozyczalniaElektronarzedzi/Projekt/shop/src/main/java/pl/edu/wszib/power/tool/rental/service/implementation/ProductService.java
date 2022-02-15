package pl.edu.wszib.power.tool.rental.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.power.tool.rental.database.IProductDAO;
import pl.edu.wszib.power.tool.rental.model.Product;
import pl.edu.wszib.power.tool.rental.service.IProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductDAO productDAO;

    public List<Product> getAllProducts() {
        return this.productDAO.getProducts();
    }

    @Override
    public void add(Product product) {
        Product productNew = new Product();
        productNew.setName(product.getName());
        productNew.setDescription(product.getDescription());
        productNew.setPrice(product.getPrice());
        productNew.setQuantity(product.getQuantity());

        this.productDAO.addProduct(productNew);
    }

    @Override
    public void modify(Product product) {
        this.productDAO.updateProduct(product);
    }

    @Override
    public Optional<Product> getProductById(int productId) {
        return this.productDAO.getProductById(productId);
    }
}
