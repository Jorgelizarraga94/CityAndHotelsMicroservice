package com.gestionHotels.hotels.service;

import com.gestionHotels.hotels.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService{

    List<Hotel> hotelList;

    @Override
    public List<Hotel> getHotelsByCityId(Long city_id) {

        List<Hotel> hotelCityList = new ArrayList<>();
        this.loadHotels();

        System.out.println(hotelList.size());

        for (Hotel hotel : hotelList){
            if(hotel.getCity_id().equals(city_id)){
                hotelCityList.add(hotel);
            }
        }
        return hotelCityList;
    }

    public void loadHotels(){
        this.hotelList = new ArrayList<>();

        hotelList.add(new Hotel(1L,"paradise",5,1L));
        hotelList.add(new Hotel(2L,"sunset",5,1L));
        hotelList.add(new Hotel(3L,"south",4,2L));
        hotelList.add(new Hotel(4L,"stars",5,2L));
    }

}
