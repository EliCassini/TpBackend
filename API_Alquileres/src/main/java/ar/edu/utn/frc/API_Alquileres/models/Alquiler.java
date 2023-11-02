package ar.edu.utn.frc.API_Alquileres.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ALQUILERES")
@Data
@NoArgsConstructor
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ID_CLIENTE")
    private String id_cliente;
    @Column(name = "ESTADO")
    private int estado;
    @Column(name = "ESTACION_RETIRO")
    private int estacion_retiro;
    @Column(name = "ESTACION_DEVOLUCION")
    private int estacion_devolucion;
    @Column(name = "FECHA_HORA_RETIRO")
    private LocalDateTime fecha_hora_retiro;
    @Column(name = "FECHA_HORA_DEVOLUCION")
    private LocalDateTime fecha_hora_devolucion;
    @Column(name = "MONTO")
    private float monto;
    @Column(name = "ID_TARIFA")
    private long id_tarifa;
}
