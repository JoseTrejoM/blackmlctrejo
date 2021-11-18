package com.yega.mlc.service.impl;

import com.yega.mlc.dto.GetPropuestaResponseDTO;
import com.yega.mlc.dto.VPlanbbDTO;
import com.yega.mlc.entity.VpropuestaBeneficiariosBeneficios;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service("propuestaServiceWeb")
public class PropuestaServiceWebImpl extends PropuestaServiceImpl {

    @Override
    public GetPropuestaResponseDTO getPropuestaByCurp(String curp) {
        var propuestaResponse = super.getPropuestaByCurp(curp);

        List<VpropuestaBeneficiariosBeneficios> vPropuestaBBList = vpropuestaBeneficiariosBeneficiosRepository.findByCurp(curp);
        if (!CollectionUtils.isEmpty(vPropuestaBBList)) {
            var primerRegistro = vPropuestaBBList.get(0);
            if (primerRegistro.getServiciocontratadoid() != null) {
                var  plan = mapper(primerRegistro, VPlanbbDTO.class);
                propuestaResponse.setPlan(plan);
            }            
        }
        return propuestaResponse;
    }
}
