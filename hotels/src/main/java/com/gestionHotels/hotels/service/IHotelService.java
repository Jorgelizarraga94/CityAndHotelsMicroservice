package com.gestionHotels.hotels.service;

import com.gestionHotels.hotels.model.Hotel;

import java.util.List;

public interface IHotelService {
    public List<Hotel> getHotelsByCityId(Long city_id);
}
