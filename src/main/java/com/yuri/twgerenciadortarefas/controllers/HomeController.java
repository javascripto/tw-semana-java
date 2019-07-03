package com.yuri.twgerenciadortarefas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("home/home");
        mv.addObject("mensagem", "Mensagem do controller");

        return mv;
    }
}
