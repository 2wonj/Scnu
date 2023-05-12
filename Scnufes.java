package com.example.practice.entity;

import javax.persistence.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Scnufes {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column
    private String festitle;

    @Column
    private String starttime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    @Column
    private String endtime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));;

    @Column
    private String location;

    @Column
    private String info;
}
