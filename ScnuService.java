package com.example.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.entity.Scnufes;
import com.example.practice.repository.ScnuRepository;

@Service
public class ScnuService {

    @Autowired
    private ScnuRepository scnuRepository;

    public void save(Scnufes files) {
        Scnufes f = new Scnufes();
        f.setFilename(files.getFilename());
        f.setFileOriName(files.getFileOriName());
        f.setFileurl(files.getFileurl());
        f.setId(files.getId());
        f.setStarttime(files.getStarttime());
        f.setEndtime(files.getEndtime());
        f.setInfo(files.getInfo());
        f.setPlace(files.getPlace());
        f.setFestitle(files.getFestitle());

        scnuRepository.save(f);
    }

    
}
