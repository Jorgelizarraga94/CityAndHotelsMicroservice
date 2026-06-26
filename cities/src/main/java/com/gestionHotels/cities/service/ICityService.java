package com.gestionHotels.cities.service;

import com.gestionHotels.cities.dto.CityDTO;
import com.gestionHotels.cities.model.City;

public interface ICityService {
    public CityDTO getcitiesHotels(String name, String country);
}
