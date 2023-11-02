package ar.edu.utn.frc.API_Alquileres.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarifaDTO {
    @Id
    @GeneratedValue(generator = "TARIFAS")
    @TableGenerator(name = "TARIFAS", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="ID",
            initialValue=1, allocationSize=1)
    private long id;
    @Column(name = "TIPO_TARIFA")
    private long tipo_tarifa;
    @Column(name = "DEFINICION")
    private String definicion;
    @Column(name = "DIA_SEMANA")
    private int dia_semana;
    @Column(name = "DIA_MES")
    private int dia_mes;
    @Column(name = "MES")
    private int mes;
    @Column(name = "anio")
    private int anio;
    @Column(name = "MONTO_FIJO_ALQUILER")
    private float monto_fijo_alquiler;
    @Column(name = "MONTO_MINUTO_FRACCION")
    private float monto_minuto_fraccion;
    @Column(name = "MONTO_KM")
    private float monto_km;
    @Column(name = "MONTO_HORA")
    private float monto_hora;

}
