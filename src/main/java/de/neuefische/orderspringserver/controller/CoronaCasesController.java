package de.neuefische.orderspringserver.controller;

import de.neuefische.orderspringserver.model.CoronaCases;
import de.neuefische.orderspringserver.service.CoronaCasesApiService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("coronacases")
public class CoronaCasesController {

    private final CoronaCasesApiService coronaCasesApiService;

    public CoronaCasesController(CoronaCasesApiService coronaCasesApiService) {
        this.coronaCasesApiService = coronaCasesApiService;
    }

    @GetMapping("{country}")
    public CoronaCases getCoronaCasesByCountry(@PathVariable String country) {
        Optional<CoronaCases> coronaCasesOptional = coronaCasesApiService.getCoronaCasesByCountry(country);
        if (coronaCasesOptional.isPresent()) {
            return coronaCasesOptional.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country " + country + " not found. ");

    }

}
