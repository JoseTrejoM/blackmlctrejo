package com.yega.mlc.repository;

import com.yega.mlc.entity.RespuestaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<RespuestaEntity, Integer>, RepositoryQuery<RespuestaEntity>{
}
