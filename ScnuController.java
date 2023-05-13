package com.example.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.practice.dto.ScnuForm;
import com.example.practice.entity.Scnufes;
import com.example.practice.repository.ScnuRepository;


@Controller
public class ScnuController {

    @Autowired
    private ScnuRepository scnuRepository; 

    @GetMapping("/main")
    public String scnumain() {

        return "scnus/main";
    }

    @GetMapping("/main/{location}") 
    public String scnuevent(@PathVariable String location, Model model) {

        List<Scnufes> scnuEntitys = scnuRepository.findBylocation(location);

        model.addAttribute("events", scnuEntitys);

        return "scnus/event";
    }    
    




    @GetMapping("/scnu")
    public String festivaltest() {
        
        return "scnus/scnu";
    }

    @PostMapping("/scnu/create")
    public String fesCreateForm(ScnuForm form){
        Scnufes fes = form.toEntity();

        scnuRepository.save(fes);

        return "redirect:https://www.scnu.ac.kr/SCNU/main.do";
    }
}
