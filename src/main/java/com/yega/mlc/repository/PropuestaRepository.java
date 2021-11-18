package com.yega.mlc.repository;

import com.yega.mlc.entity.Tpropuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropuestaRepository extends JpaRepository<Tpropuesta, Integer> {


    /*@Query("select p from Tpropuesta p where p.curp = ?1")*/
    Tpropuesta findTpropuestaByCurp(String curp);


}
