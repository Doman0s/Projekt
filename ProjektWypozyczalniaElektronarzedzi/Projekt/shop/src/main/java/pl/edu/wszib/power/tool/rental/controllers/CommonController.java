package pl.edu.wszib.power.tool.rental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.power.tool.rental.service.IProductService;
import pl.edu.wszib.power.tool.rental.session.Session;

import javax.annotation.Resource;

@Controller
public class CommonController {
    @Autowired
    IProductService productService;

    @Resource
    Session session;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("products", this.productService.getAllProducts());
        model.addAttribute("logged", this.session.isLogged());
        model.addAttribute("whoIsLogged", this.session.whoIsLogged());
        model.addAttribute("user", this.session.whoIsLogged());
        return "main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("logged", this.session.isLogged());
        model.addAttribute("whoIsLogged", this.session.whoIsLogged());
        model.addAttribute("user", this.session.whoIsLogged());
        return "contact";
    }
}
