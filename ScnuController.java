package com.example.practice.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.practice.dto.ScnuForm;
import com.example.practice.entity.Scnufes;
import com.example.practice.repository.ScnuRepository;
import com.example.practice.service.ScnuService;


@Controller
public class ScnuController {

    @Autowired
    private ScnuRepository scnuRepository; 

    @Autowired
    private ScnuService scnuService;

    @GetMapping("/main")
    public String scnumain() {

        return "scnus/main";
    }

    @GetMapping("/main/{place}") 
    public String scnuevent(@PathVariable String place, Model model) {

        List<Scnufes> scnuEntitys = scnuRepository.findBylocation(place);

        model.addAttribute("events", scnuEntitys);

        return "scnus/event";
    }    
    
    @GetMapping("/scnu")
    public String festivaltest() {
        
        return "scnus/scnu";
    }

    @RequestMapping("/scnu/create") 
    public String fesCreateForm(ScnuForm form, HttpServletRequest request, @RequestPart MultipartFile files) throws Exception{
        
        Scnufes file = new Scnufes();
        Scnufes fes = form.toEntity();
        
        String sourceFileName = files.getOriginalFilename();
        String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase(); 
        File destinationFile;
        String destinationFileName;
        String fileUrl = "C:/Users/sport/Downloads/practice/src/main/resources/static/";
        
        do {
            destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension;
            destinationFile = new File(fileUrl + destinationFileName);
        } while (destinationFile.exists());

        destinationFile.getParentFile().mkdirs();
        files.transferTo(destinationFile);

        file.setId(fes.getId());
        file.setFestitle(fes.getFestitle());
        file.setStarttime(fes.getStarttime());
        file.setEndtime(fes.getEndtime());
        file.setPlace(fes.getPlace());
        file.setInfo(fes.getInfo());
        file.setFilename(destinationFileName);
        file.setFileOriName(sourceFileName);
        file.setFileurl(fileUrl);
        scnuService.save(file);

        return "scnus/scnu";
    }
}
