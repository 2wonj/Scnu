package com.example.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.practice.entity.Scnufes;

public interface ScnuRepository extends JpaRepository<Scnufes,Long>{
    @Override
    List<Scnufes> findAll();

    // 특정 장소의 모든 정보 조회 (행사 시작일자가 빠른순)
    @Query(value = "SELECT * FROM scnufes WHERE place = :place ORDER BY starttime", nativeQuery = true)
    List<Scnufes> findBylocation(@Param("place") String place);

    // 사진
    Scnufes findByid(Long id);
}
