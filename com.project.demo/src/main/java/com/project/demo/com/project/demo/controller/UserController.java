package com.project.demo.com.project.demo.controller;

import com.project.demo.com.project.demo.entity.User;
import com.project.demo.com.project.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/signup")
    public String showSignupPage(Model theModel){
        User user = new User();
        theModel.addAttribute("user",user);
        return "signup";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User theUser, Model theModel) {

        if (theUser.getFirstName().length() < 2){
            theModel.addAttribute("errorFirstName","First name required and must be at least 2 characters long");
            return "signup";
        }

        if (theUser.getLastName().length() < 2){
            theModel.addAttribute("errorLastName","Last name required and must be at least 2 characters long");
            return "signup";
        }

        if (!theUser.getPassword().equals(theUser.getConfirmPassword())){
            theModel.addAttribute("errorPassword","password dont match");
            return "signup";
        }


        if (!theUser.getPassword().matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*]).{8,}$")){
            theModel.addAttribute("errorPassword", "password must be at least 8 characters long,must be one lower or upper character and one special character");
            return "signup";
        }
        if (!(userService.isEmailUnique(theUser.getEmail()))){

           theModel.addAttribute("errorEmail","email must be unique");
           return "signup";
        }


        userService.save(theUser);
        return "redirect:/users/login";

    }
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping("/home")
    public String home( Model theModel)
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
        } else {
             username = principal.toString();
        }
        User user = userService.findByUserName(username);
        //System.out.println(user.toString());
        theModel.addAttribute("user",user);

        return "home";
    }

    @RequestMapping("/updateForm")
    public String updateForm(@RequestParam("user") String username,Model theModel){

        User user = userService.findByUserName(username);
        theModel.addAttribute("user",user);
        theModel.addAttribute("email",username);


        return "updateform";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User theUser,@ModelAttribute("email") String email, Model theModel) {

        if (theUser.getFirstName().length() < 2){
            theModel.addAttribute("errorFirstName","First name required and must be at least 2 characters long");
            return "updateform";
        }

        if (theUser.getLastName().length() < 2){
            theModel.addAttribute("errorLastName","Last name required and must be at least 2 characters long");
            return "updateform";
        }

        if ((!userService.isEmailUnique(theUser.getEmail())) && theUser.getEmail() != email ){

            theModel.addAttribute("errorEmail","email must be unique");
            return "updateform";
        }



        userService.updateUser(theUser,email);
        return "/home";

    }
    @RequestMapping("/updatePasswordForm")
    public String updatePassword(@RequestParam("user") String username,Model theModel){

        User user = userService.findByUserName(username);
        user.setPassword("");
        theModel.addAttribute("user",user);

        return "changepassword";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(@ModelAttribute("user") User theUser, Model theModel) {


        if (!theUser.getPassword().equals(theUser.getConfirmPassword())){
            theModel.addAttribute("errorPassword","password dont match");
            return "changepassword";
        }
        if (!theUser.getPassword().matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*]).{8,}$")){
            theModel.addAttribute("errorPassword", "password must be at least 8 characters long,must be one lower or upper character and one special character");
            return "changepassword";
        }

        userService.updatePassword(theUser,theUser.getEmail());
        return "/home";

    }



}
