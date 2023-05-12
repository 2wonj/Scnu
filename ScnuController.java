package com.example.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
