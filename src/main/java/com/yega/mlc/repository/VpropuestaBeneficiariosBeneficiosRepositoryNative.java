package com.yega.mlc.repository;


import com.yega.mlc.entity.PropuestaNativeQuery;

import java.util.List;

public interface VpropuestaBeneficiariosBeneficiosRepositoryNative
{
	List<PropuestaNativeQuery> getPropuestaBeneficioByPropuestaid(Integer propuestaid);
}
