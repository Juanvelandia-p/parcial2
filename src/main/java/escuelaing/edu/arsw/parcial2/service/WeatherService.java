package escuelaing.edu.arsw.parcial2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${alpha.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();


    public String getCityWeather(String city) {
        String requestURL = "https://api.weatherapi.com/v1/current.json?key="+apiKey+"&q="+city+"&aqi=no";
        ResponseEntity<String> response = restTemplate.getForEntity(requestURL, String.class);
        return response.getBody();
    }
    
}
