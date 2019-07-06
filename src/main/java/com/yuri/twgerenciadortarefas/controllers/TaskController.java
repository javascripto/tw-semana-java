package com.yuri.twgerenciadortarefas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("home/home");
        return mv;
    }
}
