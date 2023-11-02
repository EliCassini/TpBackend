package ar.edu.utn.frc.API_Alquileres.repositories;

import ar.edu.utn.frc.API_Alquileres.models.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
}
