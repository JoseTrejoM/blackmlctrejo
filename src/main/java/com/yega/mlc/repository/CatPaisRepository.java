package com.yega.mlc.repository;


import com.yega.mlc.entity.Cpais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatPaisRepository  extends JpaRepository<Cpais, Short>{
}
