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

    private User user=null;



    @Autowired
    private UserService userService;

//    @RequestMapping(value ="/get",method = RequestMethod.GET)
//    public void get(){
//        System.out.print(user.get);
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewLoginPage(Model model) {

        LoginForm form = new LoginForm();
        model.addAttribute("loginForm", form);
        return "loginPage";
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    public String login(Model model, LoginForm form) {

        System.out.println(form.getEmail());
        user = userService.getUser(form.getEmail(), form.getPassword());
        if (user == null) {
            return "loginPage";
        } else {
            model.addAttribute("User", user);
        }
        return "userCabinet";
    }

    @RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
    public String logout(Model model, LoginForm form) {
        System.out.println(form.getEmail());
        user = userService.getUser(form.getEmail(), form.getPassword());
        user=null;
        return "loginPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegisterPage(Model model) {

        RegisterForm form = new RegisterForm();
        model.addAttribute("registerForm", form);
        return "registerPage";
    }

    @RequestMapping(value = { "/signup"}, method = RequestMethod.POST)
    public String register(Model model, RegisterForm form) {

        System.out.println(form.getEmail());
        //User user = new User();
        user=new User();
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
        return "userCabinet";
    }


    @RequestMapping(value = { "/userCabinetModify"}, method = RequestMethod.POST)
    public String userCabinetModify(Model model, RegisterForm form) {

        System.out.println(form.getEmail());
        //User user = new User();
        //user=new User();
        user.setPassword(form.getPassword());
        user.setMobileNumber(form.getPhone());
        user.setEmail(form.getEmail());
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        user.setUsername(form.getUsername());
        user.setCountry(form.getCountry());
        user.setCity(form.getCity());
        //user = userService.addUser(user);
        user=userService.updateUser(user);
        if (user == null) {
            return "registerPage";
        } else {
            user=userService.updateUser(user);
            model.addAttribute("User", user);
        }
        return "userCabinet";
    }



    @RequestMapping(value = { "/userCabinet"}, method = RequestMethod.POST)
    public String userCabinet(Model model, RegisterForm form) {

        System.out.println(form.getEmail());
        //User user = new User();
        //user=new User();
//        user.getPassword();
//        user.getMobileNumber();
//        user.getEmail();
//        user.getName();
//        user.getSurname();
//        user.getUsername();
//        user.getCountry();
//        user.getCity();
        //user = userService.addUser(user);
        if (user == null) {
            return "registerPage";
        } else {
            model.addAttribute("User", user);
        }
        return "userCabinet";
    }



    @RequestMapping(value="/getUserByEmail",method = RequestMethod.GET)
    public String getUserByEmail(Model model,RegisterForm form){
        model.addAttribute("userByEmail",userService.getUser(form.getEmail()));
        return "success";
    }


    @RequestMapping(value="/getUserName",method = RequestMethod.GET)
    public String getUserByName(Model model,RegisterForm form){
        model.addAttribute("userByName",userService.getUserByUername(form.getUsername()));
        return "success";
    }

    @RequestMapping(value="/getContacts",method = RequestMethod.GET)
    public String getContacts(Model model,RegisterForm form){
        User users=new User();
        users.setPassword(form.getPassword());
        users.setMobileNumber(form.getPhone());
        users.setEmail(form.getEmail());
        users.setName(form.getName());
        users.setSurname(form.getSurname());
        users.setUsername(form.getUsername());
        users.setCountry(form.getCountry());
        users.setCity(form.getCity());
        model.addAttribute("contacts",userService.getContacts(users));
        return "success";
    }

    @RequestMapping(value="/addContacts",method = RequestMethod.POST)
    public String addContacts(Model model,RegisterForm form){
        userService.addContact(user,userService.getUserByUername(form.getUsername()).getId());
        return "success";
    }

    @RequestMapping(value="/getByName",method = RequestMethod.GET)
    public String getByName(Model model,RegisterForm form){
        model.addAttribute("UserGetByName",userService.getUserByUername(form.getUsername()));
        return "success";
    }


    //get user name by email
    //ad contact

<<<<<<< HEAD
    @RequestMapping(value = "/getContacts", method = RequestMethod.GET)
    public String getContacts(Model model) {
        List<User> contacts = userService.getContactsUser(user);
        model.addAttribute("contacts", contacts);
        return "contacts";
    }
=======
>>>>>>> 6843c33f5bae74850072c470572ff8b1bf50fbed

}