package escuelaing.edu.arsw.parcial2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

import escuelaing.edu.arsw.parcial2.service.WeatherService;

@RestController
@RequestMapping(value = "/status",produces = "application/json")
@CrossOrigin(origins = "https://nice-island-048dd341e.2.azurestaticapps.net")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController (WeatherService weatherService){
        this.weatherService = weatherService;
    }
    

    @RequestMapping
    public ResponseEntity<String> getCityWeather(@RequestBody String city){
        String cityWeather = weatherService.getCityWeather(city);
        return ResponseEntity.ok(cityWeather);
    }
}
