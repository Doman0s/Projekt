package pl.edu.wszib.power.tool.rental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.power.tool.rental.exceptions.AddProductException;
import pl.edu.wszib.power.tool.rental.model.Product;
import pl.edu.wszib.power.tool.rental.session.Session;
import pl.edu.wszib.power.tool.rental.service.IProductService;
import pl.edu.wszib.power.tool.rental.validators.AddProductValidator;

import javax.annotation.Resource;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @Resource
    Session session;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("logged", this.session.isLogged());
        model.addAttribute("product", new Product());
        model.addAttribute("whoIsLogged", this.session.whoIsLogged());
        model.addAttribute("user", this.session.whoIsLogged());
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Product product) {
        try {
            AddProductValidator.validateName(product.getName());
            AddProductValidator.validateDescription(product.getDescription());
            AddProductValidator.validatePrice(product.getPrice());
            AddProductValidator.validateQuantity(product.getQuantity());
            this.productService.add(product);
        } catch (AddProductException e) {
            return "redirect:/add";
        }

        return "redirect:/main";
    }

    @RequestMapping(value = "/modify/{productId}", method = RequestMethod.GET)
    public String modify(Model model, @PathVariable Integer productId) {
        model.addAttribute("logged", this.session.isLogged());
        model.addAttribute("product", new Product());
        model.addAttribute("whoIsLogged", this.session.whoIsLogged());
        model.addAttribute("user", this.session.whoIsLogged());
        model.addAttribute("product", this.productService.getProductById(productId));
        return "modify";
    }

    @RequestMapping(value = "/modify/{productId}", method = RequestMethod.POST)
    public String modify(@ModelAttribute Product product, @PathVariable Integer productId) {
        try {
            AddProductValidator.validateName(product.getName());
            AddProductValidator.validateDescription(product.getDescription());
            AddProductValidator.validatePrice(product.getPrice());
            AddProductValidator.validateQuantity(product.getQuantity());
            product.setId(productId);
            this.productService.modify(product);
        } catch (AddProductException e) {
            return "redirect:/modify";
        }

        return "redirect:/main";
    }
}
