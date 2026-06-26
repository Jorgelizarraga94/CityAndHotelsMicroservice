package com.gestionHotels.hotels.controller;

import com.gestionHotels.hotels.model.Hotel;
import com.gestionHotels.hotels.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    IHotelService servHotel;

    @GetMapping("/{city_id")
    public List<Hotel> getHotelsById(@PathVariable Long city_id){
        return servHotel.getHotelsByCityId(city_id);
    }
}
