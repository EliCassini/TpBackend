package ar.edu.utn.frc.API_Alquileres.services;
import ar.edu.utn.frc.API_Alquileres.services.response.EstacionResponseDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
@Service
public class EstacionService {
    private String urlConsultaEstacion= "http://localhost:8086/api/estacion/";
    private RestTemplate restTemplate;

    public boolean existingStation(Long idEstacion) throws Exception {
        boolean existsStation=false;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            StringBuilder requestUrl = new StringBuilder(urlConsultaEstacion);
            requestUrl
                    .append("idEstacion");

            HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
            ResponseEntity<String> stringResponse = restTemplate.exchange(requestUrl.toString(), HttpMethod.GET, httpEntity, String.class);
            EstacionResponseDTO estacionDTO = new Gson().fromJson(stringResponse.getBody(), EstacionResponseDTO.class);
            existsStation=(estacionDTO.getData().getEstacionDTO()==null?true:false);
            return existsStation;
        } catch (Exception e) {
           throw new Exception("error al consultar la estacion");
        }
    }
}
