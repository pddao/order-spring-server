package de.neuefische.orderspringserver.service;

import de.neuefische.orderspringserver.model.CoronaCases;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CoronaCasesApiService {

    private final String jsonPostmanUrl = "https://api.covid19api.com/total/country/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Optional<CoronaCases> getCoronaCasesByCountry(String country) {
        String jsonPostmanCountryUrl = jsonPostmanUrl + country;

        ResponseEntity<CoronaCases> response = restTemplate.getForEntity(jsonPostmanCountryUrl, CoronaCases.class);

        if (response.getBody() != null) {
            return Optional.of(response.getBody());
        }
        return Optional.empty();


    }
}