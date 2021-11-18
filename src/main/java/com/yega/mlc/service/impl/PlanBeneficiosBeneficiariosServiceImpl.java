package com.yega.mlc.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.yega.mlc.constants.BusinessConstants;
import com.yega.mlc.constants.EnumBeneficio;
import com.yega.mlc.constants.EnumFieldQuery;
import com.yega.mlc.constants.EnumTipoBeneficiario;
import com.yega.mlc.dto.ErrorCodeDTO;
import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.dto.PlanBeneficiosBeneficiariosDTO;
import com.yega.mlc.exception.ServiceException;
import com.yega.mlc.repository.PlanBeneficiosBeneficiariosRepository;
import com.yega.mlc.service.PlanBeneficiosBeneficiariosService;
import com.yega.mlc.utils.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PlanBeneficiosBeneficiariosServiceImpl implements PlanBeneficiosBeneficiariosService {

    @Autowired
    private PlanBeneficiosBeneficiariosRepository planBeneficiosBeneficiariosRepository;

    @Override
    public List<PlanBeneficiosBeneficiariosDTO> getAllPlans() throws ServiceException {
        try {
            var listEntity = planBeneficiosBeneficiariosRepository.findAll();
            return listEntity.stream().map(element -> mapper(element, PlanBeneficiosBeneficiariosDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            var message = String.format("Cann't get plan %s", e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }

    @Override
    public List<PlanBeneficiosBeneficiariosDTO> getPlans(Set<FieldQueryDTO> fields) throws ServiceException {
        try {
            var listEntity = planBeneficiosBeneficiariosRepository.getPlan(fields);
            return listEntity.stream().map(element -> mapper(element, PlanBeneficiosBeneficiariosDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            var message = String.format("Cann't get plan %s", e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }

    @Override
    public PlanBeneficiosBeneficiariosDTO getPlan(String curp, Map<Integer, List<Integer>> beneficioBeneficiarios) {
        try {
            Set<FieldQueryDTO> fieldsQuery = getFieldsQuery(curp, beneficioBeneficiarios);
            var planes = getPlans(fieldsQuery);
            return planes.stream().findFirst().orElse(null);
        } catch (Exception e) {
            var message = String.format("Cann't get plan %s", e.toString());
            var errorCode = new ErrorCodeDTO(HttpStatus.NOT_ACCEPTABLE, message);
            throw new ServiceException(errorCode, errorCode.getMessage());
        }
    }

    private Set<FieldQueryDTO> getFieldsQuery(String curp, Map<Integer, List<Integer>> beneficioBeneficiarios) {
        Set<FieldQueryDTO> fieldsQuery = new HashSet<FieldQueryDTO>();

        var edad = DateUtils.calcularEdadByCurp(curp);
        fieldsQuery.add(new FieldQueryDTO(BusinessConstants.Plan.CAMPO_EDAD_MINIMA, edad.getYears(),
                EnumFieldQuery.LESS_OR_EQUALS));
        fieldsQuery.add(new FieldQueryDTO(BusinessConstants.Plan.CAMPO_EDAD_MAXIMA, edad.getYears(),
                EnumFieldQuery.GREATER_OR_EQUALS));

        var tipoBeneficiariosIds = new HashSet<Integer>();
        beneficioBeneficiarios.forEach((beneficioId, beneficiarios) -> {
            beneficiarios.forEach(tipoBeneficiariosId -> {
                tipoBeneficiariosIds.add(tipoBeneficiariosId);
            });
        });

        var activo = 1;
        tipoBeneficiariosIds.forEach(tipoBeneficiarioId -> {
            var campoNombre = EnumTipoBeneficiario.valueOf(tipoBeneficiarioId).name();
            fieldsQuery.add(new FieldQueryDTO(campoNombre, activo, EnumFieldQuery.EQUALS));
        });

        final var mapSerCount = new HashMap<String, Integer>();
        beneficioBeneficiarios.forEach((beneficioId, beneficiarios) -> {
            if (EnumBeneficio.REPATRIACION_A_MEXICO.getValue() == beneficioId) {
                mapSerCount.put(EnumBeneficio.REPATRIACION_A_MEXICO.name(), beneficiarios.size());
            }

            if (EnumBeneficio.SERVICIO_FUNERARIO.getValue() == beneficioId) {
                mapSerCount.put(EnumBeneficio.SERVICIO_FUNERARIO.name(), beneficiarios.size());
            }

            var campoNombre = EnumBeneficio.valueOf(beneficioId).name();
            fieldsQuery.add(new FieldQueryDTO(campoNombre, activo, EnumFieldQuery.EQUALS));
        });

        var countRepatriacion = mapSerCount.get(EnumBeneficio.REPATRIACION_A_MEXICO.name()) != null
                ? mapSerCount.get(EnumBeneficio.REPATRIACION_A_MEXICO.name())
                : 0;
        var countFunerario = mapSerCount.get(EnumBeneficio.SERVICIO_FUNERARIO.name()) != null
                ? mapSerCount.get(EnumBeneficio.SERVICIO_FUNERARIO.name())
                : 0;
        var programa = (countRepatriacion == 1 && countFunerario == 1) ? BusinessConstants.Plan.PROGRAMA_1
                : BusinessConstants.Plan.PROGRAMA_2;
        fieldsQuery.add(new FieldQueryDTO(BusinessConstants.Plan.CAMPO_PROGRAMA, programa, EnumFieldQuery.EQUALS));

        return fieldsQuery;
    }

}
