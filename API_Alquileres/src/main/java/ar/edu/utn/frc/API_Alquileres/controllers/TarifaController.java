package ar.edu.utn.frc.API_Alquileres.controllers;

import ar.edu.utn.frc.API_Alquileres.DTO.TarifaDTO;
import ar.edu.utn.frc.API_Alquileres.services.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarifas")
public class TarifaController {
    @Autowired
    private TarifaService tarifaService;

    @GetMapping
    public ResponseEntity<List<TarifaDTO>> getAllTarifaes() {
        List<TarifaDTO> tarifas = tarifaService.findAll();
        return ResponseEntity.ok(tarifas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarifaDTO> getTarifaById(@PathVariable Long id) {
        TarifaDTO tarifa = tarifaService.findById(id);
        if (tarifa != null) {
            return ResponseEntity.ok(tarifa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TarifaDTO> createTarifa(@RequestBody TarifaDTO tarifaDto) {
        TarifaDTO createdTarifa = tarifaService.save(tarifaDto);
        return ResponseEntity.ok(createdTarifa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarifaDTO> updateTarifa(@PathVariable Long id, @RequestBody TarifaDTO tarifaDto) {
        TarifaDTO updatedTarifa = tarifaService.update(id, tarifaDto);
        if (updatedTarifa != null) {
            return ResponseEntity.ok(updatedTarifa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarifa(@PathVariable Long id) {
        tarifaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
