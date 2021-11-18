package com.yega.mlc.repository.impl;

import com.yega.mlc.entity.PropuestaNativeQuery;
import com.yega.mlc.repository.VpropuestaBeneficiariosBeneficiosRepositoryNative;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class VpropuestaBeneficiariosBeneficiosRepositoryImpl implements VpropuestaBeneficiariosBeneficiosRepositoryNative
{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<PropuestaNativeQuery> getPropuestaBeneficioByPropuestaid(Integer propuestaId) {
		String queryString = "select distinct vbb.PROPUESTAID, " +
			"                faltan.BENEFICIOID, " +
			"		 faltan.TITULOBENEFICIO, " +
			"                faltan.SUBTITULOBENEFICIO, "+
			"                faltan.CLTIPOBENEFICIARIOID as TIPOBENEFICIARIOID, " +
			"                faltan.DESCRIPCIONBENEFICIO, " +
			"                faltan.TIPOBENEFICIARIO, " +
			"                faltan.IMAGENACTIVO, " +
			"                faltan.IMAGENINACTIVO, " +
			"                faltan.IMAGENDEFAULT, " +
			"                0 as ESSELECCIONADO, " +
			"                vbb.SERVICIOBENEFICIARIOID " +
			"           from (select cb.BENEFICIOID, " +
			"                        cb.TITULOBENEFICIO, " +
			"                        cb.SUBTITULOBENEFICIO, " +
			"                        cb.DESCRIPCIONBENEFICIO, " +
			"                        r.CLTIPOBENEFICIARIOID, " +
			"                        c2.DESCRIPCION as TIPOBENEFICIARIO, " +
			"                        r.IMAGENACTIVO, " +
			"                        r.IMAGENINACTIVO, " +
			"                        r.IMAGENDEFAULT, " +
			"                        r.ESSELECCIONADO " +
			"                   from cbeneficios cb " +
			"             inner join rbeneficiosbeneficiario r on cb.BENEFICIOID       = r.BENEFICIOID " +
			"             inner join cmaestrodetalle        c2 on c2.CATALOGODETALLEID = r.CLTIPOBENEFICIARIOID" +
			"                  where cb.ACTIVO = 1 " +
			"                    and c2.ACTIVO = 1) faltan " +
			"       left join vpropuesta_beneficiarios_beneficios vbb on faltan.BENEFICIOID = vbb.BENEFICIOID " +
			"             and vbb.TIPOBENEFICIARIOID = faltan.CLTIPOBENEFICIARIOID " +
			"             and vbb.PROPUESTAID        = :propuestaid " +
			"           where vbb.PROPUESTAID       is null";
		Query query = entityManager.createNativeQuery(queryString, PropuestaNativeQuery.class);
		query.setParameter("propuestaid", propuestaId);

		return query.getResultList();
	}
}
