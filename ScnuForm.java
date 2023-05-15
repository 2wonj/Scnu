package com.example.practice.dto;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.practice.entity.Scnufes;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Data
@AllArgsConstructor 
@NoArgsConstructor

@JsonNaming(value = PropertyNamingStrategy.class)
public class ScnuForm { 
    
    private Long id;

    private String festitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String starttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String endtime;

    private String place;

    private String info;
    
    private String filename;

    private String fileOriName;

    private String fileurl;

    public Scnufes toEntity() {
        return new Scnufes(id, festitle, starttime, endtime, place, info, filename, fileOriName, fileurl);
    }

}
