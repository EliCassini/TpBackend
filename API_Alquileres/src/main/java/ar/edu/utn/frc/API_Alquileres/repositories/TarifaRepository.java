package ar.edu.utn.frc.API_Alquileres.repositories;

import ar.edu.utn.frc.API_Alquileres.models.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
}
