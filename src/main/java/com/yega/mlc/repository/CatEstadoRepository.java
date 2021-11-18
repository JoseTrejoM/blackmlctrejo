package com.yega.mlc.repository;


import com.yega.mlc.entity.Cestados;
import com.yega.mlc.entity.Cpais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatEstadoRepository extends JpaRepository<Cestados, Short> {

    List findByPaisid(Cpais paisid);
}
