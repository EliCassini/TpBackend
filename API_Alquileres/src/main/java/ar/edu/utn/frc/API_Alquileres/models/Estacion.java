package ar.edu.utn.frc.API_Alquileres.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "ESTACIONES")
@Data
@NoArgsConstructor
public class Estacion {
    @Id
    @GeneratedValue(generator = "ESTACIONES")
    @TableGenerator(name = "ESTACIONES", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="ID",
            initialValue=1, allocationSize=1)
    private long id;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name = "FECHA_HORA_CREACION")
    private String fechaHoraCreacion;

    @Column(name = "LATITUD")
    private double latitud;

    @Column(name = "LONGITUD")
    private double longitud;
}