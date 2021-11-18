package com.yega.mlc.repository;

import com.yega.mlc.entity.VbeneficiosBeneficiarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VbeneficiosBeneficiariosRepository extends JpaRepository<VbeneficiosBeneficiarios, Integer> {
}
