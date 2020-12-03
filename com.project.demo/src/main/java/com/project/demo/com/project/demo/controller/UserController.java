package com.project.demo.com.project.demo.controller;

import com.project.demo.com.project.demo.entity.User;
import com.project.demo.com.project.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignupPage(Model theModel){
        User user = new User();
        theModel.addAttribute("user",user);
        return "hallo";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User theUser, BindingResult theBindingResult){

        userService.save(theUser);
        if (theBindingResult.hasErrors()) {
            return "hallo";
        }
        else {
            return "home";
        }


    }
}
