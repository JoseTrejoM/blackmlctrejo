package com.yega.mlc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeneficiosBeneficiariosResponseDTO
{
	private Integer beneficioid;
	private String clavebeneficio;
	private String titulobeneficio;
	private String subtitulobeneficio;
	private String descripcionbeneficio;
	private Integer orden;
	private Date fechaalta;
	private Integer usuarioalta;
	private Date fechamodificacion;
	private Integer usuariomodificacion;
	private Boolean activo;

	private List<BeneficiosBeneficiariosDTO> beneficiosbeneficiarios = new ArrayList<>();
	private List<ServicioBeneficiarioDTO> servicios = new ArrayList<>();
	private MaestroDetalleDTO clreceptorpago;
	private MaestroDetalleDTO cltipobeneficio;
}
