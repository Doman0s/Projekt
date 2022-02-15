package pl.edu.wszib.power.tool.rental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.power.tool.rental.service.IOrderService;
import pl.edu.wszib.power.tool.rental.session.Session;

import javax.annotation.Resource;

@Controller
public class OrderController {
    @Autowired
    IOrderService orderService;

    @Resource
    Session session;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order() {
        if(this.session.getCart().getOrderPositions().isEmpty()) {
            return "redirect:/cart";
        }

        this.orderService.confirmOrder();
        return "redirect:/main";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orders(Model model) {
        model.addAttribute("orders", this.orderService.getLoggedUserOrders());
        model.addAttribute("logged", this.session.isLogged());
        model.addAttribute("whoIsLogged", this.session.whoIsLogged());
        model.addAttribute("user", this.session.whoIsLogged());
        return "orders";
    }
}
