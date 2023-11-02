package ar.edu.utn.frc.API_Alquileres.services;

import ar.edu.utn.frc.API_Alquileres.DTO.AlquilerDTO;
import ar.edu.utn.frc.API_Alquileres.DTO.NewAlquilerDTO;
import ar.edu.utn.frc.API_Alquileres.models.Alquiler;
import ar.edu.utn.frc.API_Alquileres.repositories.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlquilerService {
    @Autowired
    private AlquilerRepository alquilerRepository;

    public List<AlquilerDTO> findAll() {
        List<Alquiler> alquilers = alquilerRepository.findAll();
        return alquilers.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public AlquilerDTO findById(Long id) {
        Optional<Alquiler> alquiler = alquilerRepository.findById(id);
        return alquiler.map(this::convertToDto).orElse(null);
    }

    public NewAlquilerDTO save(NewAlquilerDTO alquilerDto) {
        Alquiler alquiler = convertNewAlquilerToEntity(alquilerDto);
        Alquiler savedAlquiler = alquilerRepository.save(alquiler);
        return converTotNewAlquiler(savedAlquiler);
    }

    public void deleteById(Long id) {
        alquilerRepository.deleteById(id);
    }

    public AlquilerDTO update(Long id, AlquilerDTO alquilerDto) {
        Optional<Alquiler> existingAlquiler = alquilerRepository.findById(id);
        if (existingAlquiler.isPresent()) {
            Alquiler alquiler = convertToEntity(alquilerDto);
            alquiler.setId(id);
            Alquiler updatedAlquiler = alquilerRepository.save(alquiler);
            return convertToDto(updatedAlquiler);
        } else {
            return null;
        }
    }

    private AlquilerDTO convertToDto(Alquiler alquiler) {
        AlquilerDTO alquilerDto = new AlquilerDTO();
        alquilerDto.setId(alquiler.getId());
        alquilerDto.setId_cliente(alquiler.getId_cliente());
        alquilerDto.setEstado(alquiler.getEstado());
        alquilerDto.setEstacion_retiro(alquiler.getEstacion_retiro());
        alquilerDto.setEstacion_devolucion(alquiler.getEstacion_devolucion());
        alquilerDto.setFecha_hora_retiro(alquiler.getFecha_hora_retiro());
        alquilerDto.setFecha_hora_devolucion(alquiler.getFecha_hora_devolucion());
        alquilerDto.setMonto(alquiler.getMonto());
        alquilerDto.setId_tarifa(alquiler.getId_tarifa());
        return alquilerDto;
    }
    private NewAlquilerDTO converTotNewAlquiler(Alquiler alquiler) {
        NewAlquilerDTO newAlquiler = new NewAlquilerDTO();
        newAlquiler.setId(alquiler.getId());
        newAlquiler.setId_cliente(alquiler.getId_cliente());
        newAlquiler.setEstado(alquiler.getEstado());
        newAlquiler.setEstacion_retiro(alquiler.getEstacion_retiro());
        newAlquiler.setFecha_hora_retiro(alquiler.getFecha_hora_retiro());
        return newAlquiler;
    }

    private Alquiler convertToEntity(AlquilerDTO alquilerDto) {
        Alquiler alquiler = new Alquiler();
        alquiler.setId_cliente(alquilerDto.getId_cliente());
        alquiler.setEstado(alquilerDto.getEstado());
        alquiler.setEstacion_retiro(alquilerDto.getEstacion_retiro());
        alquiler.setEstacion_devolucion(alquilerDto.getEstacion_devolucion());
        alquiler.setFecha_hora_retiro(alquilerDto.getFecha_hora_retiro());
        alquiler.setFecha_hora_devolucion(alquilerDto.getFecha_hora_devolucion());
        alquiler.setMonto(alquilerDto.getMonto());
        alquiler.setId_tarifa(alquilerDto.getId_tarifa());
        return alquiler;
    }

    private Alquiler convertNewAlquilerToEntity(NewAlquilerDTO alquilerDto) {
        Alquiler alquiler = new Alquiler();
        alquiler.setId_cliente(alquilerDto.getId_cliente());
        alquiler.setEstado(alquilerDto.getEstado());
        alquiler.setEstacion_retiro(alquilerDto.getEstacion_retiro());
        alquiler.setFecha_hora_retiro(alquilerDto.getFecha_hora_retiro());
        return alquiler;
    }
}
