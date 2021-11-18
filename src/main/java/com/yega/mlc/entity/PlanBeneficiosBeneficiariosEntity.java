package com.yega.mlc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "VPLAN_BENEFICIOS_BENEFICIARIOS")
public class PlanBeneficiosBeneficiariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIPOPLANID")
    private Integer tipoplanId;

    @Column(name = "DESCRIPCIONPLAN")
    private String descripcionPlan;

    @Column(name = "PRECIO_MENSUAL")
    private Double precioMensual;

    @Column(name = "PRECIO_ANUAL")
    private Double precioAnual;

    @Column(name = "EDADMINIMA")
    private Integer edadminima;

    @Column(name = "EDADMAXIMA")
    private Integer edadmaxima;

    @Column(name = "PROGRAMA")
    private Integer programa;

    @Column(name = "REPATRIACION_A_MEXICO")
    private Double repatriacion_a_mexico;

    @Column(name = "SERVICIO_FUNERARIO")
    private Double servicio_funerario;

    @Column(name = "SEGURO_DE_VIDA")
    private Double seguro_de_vida;

    @Column(name = "EDUCACION_FINANCIERA")
    private Double educacion_financiera;

    @Column(name = "ENVIO_DE_DINERO")
    private Double envio_de_dinero;

    @Column(name = "TITULAR")
    private Double titular;

    @Column(name = "PAREJA")
    private Double pareja;

    @Column(name = "PADRE")
    private Double padre;

    @Column(name = "MADRE")
    private Double madre;

    @Column(name = "HIJO")
    private Double hijo;
}
