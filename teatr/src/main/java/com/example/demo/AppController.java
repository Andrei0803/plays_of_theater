package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private TheaterService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Theater> listPlays = service.listAll(keyword);
        model.addAttribute("listPlays", listPlays);
        model.addAttribute("keyword", keyword);
        Float avg = service.avg();
        model.addAttribute("avg", avg);
        List<String> table = service.amount();
        System.out.println(table);
        model.addAttribute("table", table);
        return "index";
    }

    @GetMapping("/new")
    public String showNewStudentForm(Model model) {
        Theater play = new Theater();
        model.addAttribute("play", play);
        return "new_play";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSession(@ModelAttribute("session") Theater play) {
        service.save(play);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_play");
        Theater play = service.get(id);
        mav.addObject("play", play);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteSession(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}

