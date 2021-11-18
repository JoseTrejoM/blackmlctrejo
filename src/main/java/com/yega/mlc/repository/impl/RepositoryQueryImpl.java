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
import com.yega.mlc.repository.RepositoryQuery;

public class RepositoryQueryImpl<T> implements RepositoryQuery<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<T> getResultSet(Set<FieldQueryDTO> fields, Class<T> resultClass) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(resultClass);
        Root<T> planBenBen = query.from(resultClass);

        List<Predicate> predicates = new ArrayList<>();
        fields.forEach(fieldDTO -> {
            addPredicate(cb, planBenBen, fieldDTO, predicates);
        });

        query.select(planBenBen).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query).getResultList();
    }

    private void addPredicate(CriteriaBuilder cb, Root<T> planBenBen, FieldQueryDTO fieldDTO,
            List<Predicate> predicates) {
        var fieldName = fieldDTO.getFieldName();
        Path<?> field = planBenBen.get(fieldName);
        
        switch (fieldDTO.getComparator()) {
            case EQUALS:
                predicates.add(cb.equal(field, fieldDTO.getValue()));
                break;
            case GREATER_THAN:
                predicates.add(cb.gt(field.as(Number.class), (Number) fieldDTO.getValue()));
                break;
            case GREATER_OR_EQUALS:
                predicates.add(cb.ge(field.as(Number.class), (Number) fieldDTO.getValue()));
                break;
            case LESS_THAN:
                predicates.add(cb.lt(field.as(Number.class), (Number) fieldDTO.getValue()));
                break;            
            case LESS_OR_EQUALS:
                predicates.add(cb.le(field.as(Number.class), (Number) fieldDTO.getValue()));
                break;            
            default:
                predicates.add(cb.equal(field, fieldDTO.getValue()));
                break;
        }
    }

}
