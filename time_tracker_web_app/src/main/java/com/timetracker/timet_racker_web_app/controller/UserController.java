package com.timetracker.timet_racker_web_app.controller;

import com.timetracker.timet_racker_web_app.dao.service.UserService;
import com.timetracker.timet_racker_web_app.form.LoginForm;
import com.timetracker.timet_racker_web_app.form.RegisterForm;
import com.timetracker.timet_racker_web_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewLoginPage(Model model) {

        LoginForm form = new LoginForm();
        model.addAttribute("loginForm", form);
        return "loginPage";
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    public String login(Model model, LoginForm form) {

        System.out.println(form.getEmail());
        User user = userService.getUser(form.getEmail(), form.getPassword());
        if (user == null) {
            return "loginPage";
        } else {
            model.addAttribute("User", user);
        }
        return "success";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegisterPage(Model model) {

        RegisterForm form = new RegisterForm();
        model.addAttribute("registerForm", form);
        return "registerPage";
    }

    @RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
    public String register(Model model, RegisterForm form) {

        System.out.println(form.getEmail());
        User user = new User();
        user.setPassword(form.getPassword());
        user.setMobileNumber(form.getPhone());
        user.setEmail(form.getEmail());
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        user.setUsername(form.getUsername());
        user.setCountry(form.getCountry());
        user.setCity(form.getCity());
        user = userService.addUser(user);
        if (user == null) {
            return "registerPage";
        } else {
            model.addAttribute("User", user);
        }
        return "success";
    }
}
