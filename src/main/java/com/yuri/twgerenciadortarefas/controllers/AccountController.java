package com.yuri.twgerenciadortarefas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuri.twgerenciadortarefas.models.User;
import com.yuri.twgerenciadortarefas.services.UserService;

import javax.validation.Valid;


@Controller
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/registration")
    public ModelAndView registration() {
        return new ModelAndView("account/register")
            .addObject("user", new User());
    }

    @PostMapping("/registration")
    public ModelAndView registration(@Valid User user, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if (userService.findByEmail(user.getEmail()) != null) {
            result.rejectValue("email", "409", "Usuário já cadastrado");
        }
        if (result.hasErrors()) {
            mv.setViewName("account/register");
            mv.addObject("user", user);
        } else {
            userService.save(user);
            mv.setViewName("redirect:/login");
        }
        return mv;
    }
}
