package pl.edu.wszib.power.tool.rental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.power.tool.rental.service.ICartService;
import pl.edu.wszib.power.tool.rental.session.Session;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    ICartService cartService;

    @Resource
    Session session;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String cart(Model model) {
        model.addAttribute("cart", this.session.getCart());
        model.addAttribute("result", this.session.getCart().getCalculatedSum());
        model.addAttribute("logged", this.session.isLogged());
        model.addAttribute("whoIsLogged", this.session.whoIsLogged());
        model.addAttribute("user", this.session.whoIsLogged());
        return "cart";
    }

    @RequestMapping(value = "/add/{productId}/{time}")
    public String addToCart(@PathVariable Integer productId, @PathVariable Integer time) {
        this.cartService.addToCart(productId, time);
        return "redirect:/main";
    }

    @RequestMapping(value = "/delete/{productId}")
    public String deleteFromCart(@PathVariable Integer productId) {
        this.cartService.deleteFromCart(productId);
        return "redirect:/cart";
    }
}
