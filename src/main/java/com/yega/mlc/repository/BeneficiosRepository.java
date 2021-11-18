package com.yega.mlc.repository;

import com.yega.mlc.entity.Cbeneficios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficiosRepository extends JpaRepository<Cbeneficios, Integer>
{
	List<Cbeneficios> findByBeneficioid(Integer beneficioid);
}
