package com.gestionHotels.cities.service;

import com.gestionHotels.cities.dto.CityDTO;
import com.gestionHotels.cities.model.City;
import com.gestionHotels.cities.repository.IHotelAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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

    public void loadCities() {
        cityList.add(new City(1L,"Buenos Aires","American", "Argentina", "Buenos Aires"));
        cityList.add(new City(2L,"Santiago De Chile","American", "Chile", "Santiago"));
        cityList.add(new City(3L,"Montevideo","American", "Uruguay", "Maldonado"));
    }

    public CityDTO fallbackGetCitiesHotel (String name, String country, Throwable throwable){
        System.out.println("ENTRÓ AL FALLBACK CORRECTAMENTE");
        return new CityDTO(99999L, "Fallido", "Fallido", "Fallido", "Fallido",null);
    }

    public City findCity(String name, String country) {
        this.loadCities();
        City city = null;
        for (City cit : cityList){
            if(cit.getName().equals(name) && cit.getCountry().equals(country)){
                city = cit;
            }
        }
        return city;
    }


}
