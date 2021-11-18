package com.yega.mlc.repository;


import com.yega.mlc.entity.VpropuestaBeneficiariosBeneficios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VpropuestaBeneficiariosBeneficiosRepository extends JpaRepository<VpropuestaBeneficiariosBeneficios, Integer>, VpropuestaBeneficiariosBeneficiosRepositoryNative
{
	List<VpropuestaBeneficiariosBeneficios> findByCurp(String curp);
}
