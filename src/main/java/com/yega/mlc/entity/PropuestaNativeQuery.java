package com.yega.mlc.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropuestaNativeQuery implements Serializable
{
	private static final long serialVersionUID = 6400172582058468650L;

	@Id
	private Integer beneficioid;
	private String titulobeneficio;
	private String subtitulobeneficio;
	private String descripcionbeneficio;

	@Id
	//private String cltipobeneficiarioid;
	private String tipobeneficiario;
	private String imagenactivo;
	private String imageninactivo;
	private String imagendefault;
	private boolean esseleccionado;
	private Integer serviciobeneficiarioid;
	private String tipobeneficiarioid;
}
