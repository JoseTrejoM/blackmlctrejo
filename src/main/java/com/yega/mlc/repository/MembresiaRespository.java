package com.yega.mlc.repository;

import com.yega.mlc.dto.MembresiaDTO;
import com.yega.mlc.entity.MembresiaEntity;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresiaRespository extends JpaRepository<MembresiaEntity, Integer>, RepositoryQuery<MembresiaEntity>{
     public List<MembresiaEntity> findByPropuestaId(Integer propuestaId);
}
