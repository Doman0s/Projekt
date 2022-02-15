package pl.edu.wszib.power.tool.rental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.power.tool.rental.exceptions.AuthException;
import pl.edu.wszib.power.tool.rental.exceptions.LoginUsedException;
import pl.edu.wszib.power.tool.rental.exceptions.RegisterException;
import pl.edu.wszib.power.tool.rental.model.Ruser;
import pl.edu.wszib.power.tool.rental.model.User;
import pl.edu.wszib.power.tool.rental.service.IAuthService;
import pl.edu.wszib.power.tool.rental.session.Session;
import pl.edu.wszib.power.tool.rental.validators.LoginValidator;
import pl.edu.wszib.power.tool.rental.validators.RegisterValidator;

import javax.annotation.Resource;

@Controller
public class AuthController {
    @Autowired
    IAuthService authService;

    @Resource
    Session session;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("logged", this.session.isLogged());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password) {
        try {
            LoginValidator.validateLogin(login);
            LoginValidator.validatePassword(password);
        } catch (AuthException e) {
            return "redirect:/login";
        }

        this.authService.login(login, password);

        if(this.session.isLogged()) {
            return "redirect:/main";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.session.getCart().clearOrders();
        this.session.setUser(null);
        return "redirect:/main";
    }

    @RequestMapping(value = {"/register", "addUser"}, method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("logged", this.session.isLogged());
        model.addAttribute("ruser", new Ruser());
        return "register";
    }

    @RequestMapping(value = {"/register", "addUser"}, method = RequestMethod.POST)
    public String register(@ModelAttribute Ruser Ruser) {
        try {
            RegisterValidator.validateName(Ruser.getName());
            RegisterValidator.validateSurname(Ruser.getSurname());
            LoginValidator.validateLogin(Ruser.getLogin());
            LoginValidator.validatePassword(Ruser.getPassword());
            RegisterValidator.validatePasswords(Ruser.getPassword(), Ruser.getSecondPassword());
            this.authService.register(Ruser);
        } catch (AuthException | LoginUsedException | RegisterException e) {
            return "redirect:/register";
        }

        return "redirect:/main";
    }

    @RequestMapping(value = {"/modifyUser"}, method = RequestMethod.GET)
    public String modifyUser(Model model) {
        model.addAttribute("logged", this.session.isLogged());
        model.addAttribute("user", this.session.getUser());
        return "modifyUser";
    }

    @RequestMapping(value = {"/modifyUser"}, method = RequestMethod.POST)
    public String modifyUser(@ModelAttribute User user) {
        try {
            RegisterValidator.validateName(user.getName());
            RegisterValidator.validateSurname(user.getSurname());
            LoginValidator.validateLogin(user.getLogin());
            this.authService.modifyUser(user);
        } catch (AuthException | LoginUsedException | RegisterException e) {
            return "redirect:/modifyUser";
        }

        this.session.getCart().clearOrders();
        this.session.setUser(null);
        return "redirect:/main";
    }

    @RequestMapping(value = {"/changePassword"}, method = RequestMethod.GET)
    public String changePassword(Model model) {
        model.addAttribute("logged", this.session.isLogged());
        model.addAttribute("ruser", new Ruser());
        return "changePassword";
    }

    @RequestMapping(value = {"/changePassword"}, method = RequestMethod.POST)
    public String changePassword(@ModelAttribute Ruser ruser) {
        try {
            LoginValidator.validatePassword(ruser.getPassword());
            RegisterValidator.validatePasswords(ruser.getPassword(), ruser.getSecondPassword());
            this.authService.changePassword(ruser);
        } catch (AuthException | RegisterException e) {
            return "redirect:/changePassword";
        }

        this.session.getCart().clearOrders();
        this.session.setUser(null);
        return "redirect:/main";
    }
}