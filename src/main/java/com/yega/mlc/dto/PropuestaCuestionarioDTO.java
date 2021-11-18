package com.yega.mlc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropuestaCuestionarioDTO
{

	private Integer propuestaid;
	private Integer beneficiarioid;
	private Integer serviciobeneficiarioid;
	private Integer preguntaid;
	private String descripcionpregunta;
	private Integer respuestaid;
	private String respuesta;
	
	
	public Integer getPropuestaid() {
		return propuestaid;
	}
	public void setPropuestaid(Integer propuestaid) {
		this.propuestaid = propuestaid;
	}
	public Integer getBeneficiarioid() {
		return beneficiarioid;
	}
	public void setBeneficiarioid(Integer beneficiarioid) {
		this.beneficiarioid = beneficiarioid;
	}
	public Integer getServiciobeneficiarioid() {
		return serviciobeneficiarioid;
	}
	public void setServiciobeneficiarioid(Integer serviciobeneficiarioid) {
		this.serviciobeneficiarioid = serviciobeneficiarioid;
	}
	public Integer getPreguntaid() {
		return preguntaid;
	}
	public void setPreguntaid(Integer preguntaid) {
		this.preguntaid = preguntaid;
	}
	public String getDescripcionpregunta() {
		return descripcionpregunta;
	}
	public void setDescripcionpregunta(String descripcionpregunta) {
		this.descripcionpregunta = descripcionpregunta;
	}
	public Integer getRespuestaid() {
		return respuestaid;
	}
	public void setRespuestaid(Integer respuestaid) {
		this.respuestaid = respuestaid;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
}
