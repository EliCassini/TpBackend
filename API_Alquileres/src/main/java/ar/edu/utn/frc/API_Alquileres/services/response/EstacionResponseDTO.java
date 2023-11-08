package ar.edu.utn.frc.API_Alquileres.services.response;

import ar.edu.utn.frc.API_Alquileres.DTO.EstacionDTO;
import lombok.Data;
@Data
public class EstacionResponseDTO{
    private EstacionResponseDTO.Data data;

    public EstacionResponseDTO() {
        super();
    }

    public EstacionResponseDTO(String resultado) {
        super();
        this.setData(new Data("ERROR"));
    }

    public static class Data {
        private String resultado;
        private EstacionDTO estacionDTO;


        public Data() {
            super();
        }

        public Data(String resultado) {
            this.resultado = resultado;
        }

        public Data(EstacionDTO estacionDTO) {
            this.estacionDTO = estacionDTO;
         }



        public String getResultado() {
            return resultado;
        }

        public void setResultado(String resultado) {
            this.resultado = resultado;
        }

        public EstacionDTO getEstacionDTO() {
            return estacionDTO;
        }

        public void setEstacionDTO(EstacionDTO estacionDTO) {
            this.estacionDTO = estacionDTO;
        }
    }

    public EstacionResponseDTO.Data getData() {
        return data;
    }

    public void setData(EstacionResponseDTO.Data data) {
        this.data = data;
    }


}

