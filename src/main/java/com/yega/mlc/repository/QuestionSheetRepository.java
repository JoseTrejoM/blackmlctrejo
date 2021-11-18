package com.yega.mlc.repository;

import com.yega.mlc.entity.CuestionarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionSheetRepository extends JpaRepository<CuestionarioEntity, Integer> {
    
}
