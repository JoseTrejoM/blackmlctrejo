package com.yega.mlc.repository;


import com.yega.mlc.entity.VpropuestaCuestionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VpropuestaCuestionarioRepository extends JpaRepository<VpropuestaCuestionario, Integer>
{
	List<VpropuestaCuestionario> findByPropuestaid(Integer propuestaid);
}
