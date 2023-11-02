package ar.edu.utn.frc.API_Alquileres.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlquilerDTO {

    private long id;
    private String id_cliente;
    private int estado;
    private int estacion_retiro;
    private int estacion_devolucion;
    private LocalDateTime fecha_hora_retiro;
    private LocalDateTime fecha_hora_devolucion;
    private float monto;
    private long id_tarifa;
}
