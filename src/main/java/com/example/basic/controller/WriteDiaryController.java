package com.example.basic.controller;

import com.example.basic.model.Diary;
import com.example.basic.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class WriteDiaryController {

    @Autowired
    private final DiaryService diaryService;

    public WriteDiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @RequestMapping(value = "/write")
    public String displayWritePage(Model model) {
    model.addAttribute("diary",new Diary());


        return "write.html";
    }

    @RequestMapping(value = "/saveDiary",method = POST)
    public String saveMessageInController(@Valid @ModelAttribute("diary") Diary diary, Errors errors) {
        diaryService.saveMessageInService(diary);
    if(errors.hasErrors()) {
        return "redirect:/write";
    }
    return "redirect:/messages";

    }

    @RequestMapping("/messages")
    public ModelAndView displayMessages(Model model) {
    List<Diary> diaryList=diaryService.findMessages();
    ModelAndView modelAndView=new ModelAndView("messages.html");
    modelAndView.addObject("diaryMessages",diaryList);


        return modelAndView;

    }

}
