package com.yuri.twgerenciadortarefas.controllers;

import java.util.Date;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import com.yuri.twgerenciadortarefas.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.yuri.twgerenciadortarefas.models.User;
import com.yuri.twgerenciadortarefas.models.Task;
import com.yuri.twgerenciadortarefas.repositories.TaskRepository;


@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ModelAndView list(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tasks/list");
        String userEmail = request.getUserPrincipal().getName();
        mv.addObject("tasks", taskRepository.getTasksByUser(userEmail));
        return mv;
    }

    @GetMapping("/insert")
    public ModelAndView insert() {
        ModelAndView mv = new ModelAndView("tasks/insert");
        mv.addObject("task", new Task());
        return mv;
    }

    @PostMapping("/insert")
    public ModelAndView create(@Valid Task task, BindingResult result, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("tasks/insert");
        if (task.getExpirationDate() == null) {
            result.rejectValue(
                    "expirationDate",
                    "task.invalidExpirationDate",
                    "A data de expiração é obrigatória."
            );
        }
        if (task.getExpirationDate().before(new Date())) {
            result.rejectValue(
                    "expirationDate",
                    "task.invalidExpirationDate",
                    "A data de expiração não pode ser anterior à data atual."
            );
        }
        if (!result.hasErrors()) {
            mv.setViewName("redirect:/tasks/list");
            String userEmail = request.getUserPrincipal().getName();
            User loggedInUser = userService.findByEmail(userEmail);
            task.setUser(loggedInUser);
            taskRepository.save(task);
            return mv;
        }
        mv.addObject("task", task);
        mv.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        return mv;
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("tasks/update");
        Task task = taskRepository.getOne(id);
        mv.addObject(task);
        return mv;
    }

    @PostMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") Long id, @Valid Task task, BindingResult result) {
        ModelAndView mv = new ModelAndView("tasks/update");
        if (task.getExpirationDate() == null) {
            result.rejectValue(
                    "expirationDate",
                    "task.invalidExpirationDate",
                    "A data de expiração é obrigatória."
            );
        }
        if (task.getExpirationDate().before(new Date())) {
            result.rejectValue(
                    "expirationDate",
                    "task.invalidExpirationDate",
                    "A data de expiração não pode ser anterior à data atual."
            );
        }
        if (!result.hasErrors()) {
            mv.setViewName("redirect:/tasks/list");
            taskRepository.save(task);
            return mv;
        }
        mv.addObject("task", task);
        mv.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        return mv;
    }

    @GetMapping("/remove/{id}")
    public String removeTask(@PathVariable("id") Long id) {
        taskRepository.deleteById(id);
        return "redirect:/tasks/list";
    }

    @GetMapping("/close/{id}")
    public String closeTask(@PathVariable("id") Long id) {
        Task task = taskRepository.getOne(id);
        task.setDone(true);
        taskRepository.save(task);
        return "redirect:/tasks/list";
    }
}
