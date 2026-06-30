package com.gestionHotels.cities.repository;

import com.gestionHotels.cities.dto.CityDTO;
import com.gestionHotels.cities.dto.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("hotels-service")
public interface IHotelAPI {
    @GetMapping("/hotels/{city_id}")
    public List<HotelDTO> getHotels(@PathVariable("city_id") Long city_id);
}
