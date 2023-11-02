package ar.edu.utn.frc.API_Alquileres.services;

import ar.edu.utn.frc.API_Alquileres.DTO.TarifaDTO;
import ar.edu.utn.frc.API_Alquileres.models.Tarifa;
import ar.edu.utn.frc.API_Alquileres.repositories.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarifaService {
    @Autowired
    private TarifaRepository tarifaRepository;

    public List<TarifaDTO> findAll() {
        List<Tarifa> tarifas = tarifaRepository.findAll();
        return tarifas.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public TarifaDTO findById(Long id) {
        Optional<Tarifa> tarifa = tarifaRepository.findById(id);
        return tarifa.map(this::convertToDto).orElse(null);
    }

    public TarifaDTO save(TarifaDTO tarifaDto) {
        Tarifa tarifa = convertToEntity(tarifaDto);
        Tarifa savedTarifa = tarifaRepository.save(tarifa);
        return convertToDto(savedTarifa);
    }

    public void deleteById(Long id) {
        tarifaRepository.deleteById(id);
    }

    public TarifaDTO update(Long id, TarifaDTO tarifaDto) {
        Optional<Tarifa> existingTarifa = tarifaRepository.findById(id);
        if (existingTarifa.isPresent()) {
            Tarifa tarifa = convertToEntity(tarifaDto);
            tarifa.setId(id);
            Tarifa updatedTarifa = tarifaRepository.save(tarifa);
            return convertToDto(updatedTarifa);
        } else {
            return null;
        }
    }

    private TarifaDTO convertToDto(Tarifa tarifa) {
        TarifaDTO tarifaDto = new TarifaDTO();
        tarifaDto.setId(tarifa.getId());
        tarifaDto.setTipo_tarifa(tarifa.getTipo_tarifa());
        tarifaDto.setDefinicion(tarifa.getDefinicion());
        tarifaDto.setDia_semana(tarifa.getDia_semana());
        tarifaDto.setDia_mes(tarifa.getDia_mes());
        tarifaDto.setMes(tarifa.getMes());
        tarifaDto.setAnio(tarifa.getAnio());
        tarifaDto.setMonto_fijo_alquiler(tarifa.getMonto_fijo_alquiler());
        tarifaDto.setMonto_minuto_fraccion(tarifa.getMonto_minuto_fraccion());
        tarifaDto.setMonto_km(tarifa.getMonto_km());
        tarifaDto.setMonto_hora(tarifa.getMonto_hora());
        return tarifaDto;
    }

    private Tarifa convertToEntity(TarifaDTO tarifaDto) {
        Tarifa tarifa = new Tarifa();
        tarifa.setId(tarifaDto.getId());
        tarifa.setTipo_tarifa(tarifaDto.getTipo_tarifa());
        tarifa.setDefinicion(tarifaDto.getDefinicion());
        tarifa.setDia_semana(tarifaDto.getDia_semana());
        tarifa.setDia_mes(tarifaDto.getDia_mes());
        tarifa.setMes(tarifaDto.getMes());
        tarifa.setAnio(tarifaDto.getAnio());
        tarifa.setMonto_fijo_alquiler(tarifaDto.getMonto_fijo_alquiler());
        tarifa.setMonto_minuto_fraccion(tarifaDto.getMonto_minuto_fraccion());
        tarifa.setMonto_km(tarifaDto.getMonto_km());
        tarifa.setMonto_hora(tarifaDto.getMonto_hora());
        return tarifa;
    }
}
