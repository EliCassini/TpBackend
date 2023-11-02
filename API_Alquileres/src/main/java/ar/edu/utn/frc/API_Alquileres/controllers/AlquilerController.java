package ar.edu.utn.frc.API_Alquileres.controllers;

import ar.edu.utn.frc.API_Alquileres.DTO.AlquilerDTO;
import ar.edu.utn.frc.API_Alquileres.DTO.NewAlquilerDTO;
import ar.edu.utn.frc.API_Alquileres.services.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AlquilerController {

    @Autowired
    private AlquilerService alquilerService;

    @GetMapping
    public ResponseEntity<List<AlquilerDTO>> getAllAlquileres() {
        List<AlquilerDTO> alquileres = alquilerService.findAll();
        return ResponseEntity.ok(alquileres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlquilerDTO> getAlquilerById(@PathVariable Long id) {
        AlquilerDTO alquiler = alquilerService.findById(id);
        if (alquiler != null) {
            return ResponseEntity.ok(alquiler);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<NewAlquilerDTO> createAlquiler(@RequestBody NewAlquilerDTO alquilerDto) {
        NewAlquilerDTO createdAlquiler = alquilerService.save(alquilerDto);
        return ResponseEntity.ok(createdAlquiler);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlquilerDTO> updateAlquiler(@PathVariable Long id, @RequestBody AlquilerDTO alquilerDto) {
        AlquilerDTO updatedAlquiler = alquilerService.update(id, alquilerDto);
        if (updatedAlquiler != null) {
            return ResponseEntity.ok(updatedAlquiler);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlquiler(@PathVariable Long id) {
        alquilerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
