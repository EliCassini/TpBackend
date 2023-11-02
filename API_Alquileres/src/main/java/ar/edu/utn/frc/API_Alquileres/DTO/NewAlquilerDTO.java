package ar.edu.utn.frc.API_Alquileres.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewAlquilerDTO {
    private long id;
    private String id_cliente;
    private int estado;
    private int estacion_retiro;
    private LocalDateTime fecha_hora_retiro;
}
