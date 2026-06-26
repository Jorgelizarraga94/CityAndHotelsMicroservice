package com.gestionHotels.cities.service;

import com.gestionHotels.cities.dto.CityDTO;
import com.gestionHotels.cities.model.City;
import com.gestionHotels.cities.repository.IHotelAPI;
import com.netflix.discovery.converters.Auto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService{
    @Autowired
    IHotelAPI hotelAPI;

    List<City> cityList = new ArrayList<>();
    @Override
    @CircuitBreaker(name="hotels", fallbackMethod = "fallbackGetCitiesHotel")
    public CityDTO getcitiesHotels(String name, String country) {
        City city = this.findCity(name,country);

        CityDTO cityDTO = new CityDTO();

        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setContinent(city.getContinent());
        cityDTO.setCountry(city.getCountry());
        cityDTO.setState(city.getState());

        cityDTO.setHotelList(hotelAPI.getHotels(city.getId()));

        return cityDTO;
    }

    private City findCity(String name, String country) {
        this.loadCities();
        City city = null;
        for (City cit : cityList){
            if(city.getName().equals(name) && city.getCountry().equals(country)){
                city = cit;
            }
        }
        return city;
    }

    private void loadCities() {
        cityList.add(new City(1L,"Buenos Aires","American", "Argentina", "Buenos Aires"));
        cityList.add(new City(2L,"Santiago De Chile","American", "Chile", "Santiago"));
        cityList.add(new City(3L,"Montevideo","American", "Uruguay", "Maldonado"));
    }
}
