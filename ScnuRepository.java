package com.example.practice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.practice.entity.Scnufes;

public interface ScnuRepository extends CrudRepository<Scnufes,Long>{
    @Override
    List<Scnufes> findAll();

}
