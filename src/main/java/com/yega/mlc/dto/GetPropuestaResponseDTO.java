package com.yega.mlc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetPropuestaResponseDTO
{
	private Integer propuestaid;
	private String curp;
	private String estatuspropuesta;
	private Integer clestatuspropuestaid;
	private Integer flag;
	private List<BeneficiosBeneficiariosResponseDTO> beneficios;
	private List<PropuestaCuestionarioDTO> cuestionario;
	private VPlanbbDTO plan;
}
