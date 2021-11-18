package com.yega.mlc.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.yega.mlc.dto.FieldQueryDTO;
import com.yega.mlc.entity.PlanBeneficiosBeneficiariosEntity;
import com.yega.mlc.repository.PlanBeneficiosBeneficiariosRepositoryQ;

public class PlanBeneficiosBeneficiariosRepositoryQImpl implements PlanBeneficiosBeneficiariosRepositoryQ {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PlanBeneficiosBeneficiariosEntity> getPlan(Set<FieldQueryDTO> fields) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PlanBeneficiosBeneficiariosEntity> query = cb
                .createQuery(PlanBeneficiosBeneficiariosEntity.class);
        Root<PlanBeneficiosBeneficiariosEntity> planBenBen = query.from(PlanBeneficiosBeneficiariosEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        fields.forEach(fieldDTO -> {
            addPredicate(cb, planBenBen, fieldDTO, predicates);
        });

        query.select(planBenBen).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query).getResultList();
    }

    private void addPredicate(CriteriaBuilder cb, Root<PlanBeneficiosBeneficiariosEntity> planBenBen,
            FieldQueryDTO fieldDTO, List<Predicate> predicates) {
        Path<Object> field = planBenBen.get(fieldDTO.getFieldName().toLowerCase());
        Path<Number> fieldNumber = planBenBen.get(fieldDTO.getFieldName().toLowerCase());
        switch (fieldDTO.getComparator()) {
            case EQUALS:
                predicates.add(cb.equal(field, fieldDTO.getValue()));
                break;
            case GREATER_OR_EQUALS:
                predicates.add(cb.ge(fieldNumber, Integer.valueOf(fieldDTO.getValue().toString())));
                break;
            case LESS_OR_EQUALS:
                predicates.add(cb.le(fieldNumber, Integer.valueOf(fieldDTO.getValue().toString())));
                break;
            default:
                predicates.add(cb.equal(field, fieldDTO.getValue()));
                break;
        }
    }

}
