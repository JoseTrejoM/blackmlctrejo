package com.yega.mlc.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TPERSONAFISICA")
public class PersonaFisicaEntity {
    @Id
    @Column(name = "PERSONAFISICAID")
    private Integer personaFisicaId;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "PRIMERAPELLIDO")
    private String primerApellido;

    @Column(name = "SEGUNDOAPELLIDO")
    private String segundoApellido;

    @Column(name = "CLSEXOID")
    private Integer sexoId;

    @Column(name = "FECHANACIMIENTO")
    private Date fechaNacimiento;

    @Column(name = "FECHAALTA")
    private Date fechaAlta;

    @Column(name = "CURP")
    private String curp;

    @Column(name = "NSS")
    private String nss;

}
