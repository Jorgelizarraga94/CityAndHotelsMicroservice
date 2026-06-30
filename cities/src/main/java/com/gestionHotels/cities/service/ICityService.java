package com.gestionHotels.cities.service;

import com.gestionHotels.cities.dto.CityDTO;
import com.gestionHotels.cities.model.City;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
@CircuitBreaker(name = "hotels", fallbackMethod = "fallbackGetCitiesHotel")
public interface ICityService {
    public CityDTO getcitiesHotels(String name, String country);
}
