package com.verkhogliadoval.controller;

import com.verkhogliadoval.entity.User;
import com.verkhogliadoval.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Passwords don`t match");
            return "registration";
        }
        if(userForm.getUsername().matches("[0-9]+") ){
            model.addAttribute("usernameError","Your username should consist only with characters");
            return "registration";
        }
        if(userForm.getUsername().length()<5 ){
            model.addAttribute("usernameError","Your username should have at least 5  characters");
            return "registration";
        }

        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "User with such name already exists");
            return "registration";
        }

        return "redirect:/";
    }
}
