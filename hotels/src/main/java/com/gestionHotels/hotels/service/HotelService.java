package com.gestionHotels.hotels.service;

import com.gestionHotels.hotels.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService{

    List<Hotel> hotelList=new ArrayList<>();
    @Override
    public List<Hotel> getHotelsByCityId(Long city_id) {
        List<Hotel> hotelCityList = new ArrayList<>();

        this.loadHotels();

        for (Hotel hotel : hotelList){
            if(hotel.getCity_id() == city_id){
                hotelCityList.add(hotel);
            }
        }

        return hotelCityList;
    }

    public void loadHotels(){
        hotelList.add(new Hotel(1L,"paradise",5,1L));
        hotelList.add(new Hotel(2L,"sunset",5,1L));
        hotelList.add(new Hotel(3L,"south",4,2L));
        hotelList.add(new Hotel(4L,"stars",5,2L));
    }

}
