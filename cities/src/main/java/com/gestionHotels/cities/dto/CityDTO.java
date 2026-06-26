package com.gestionHotels.cities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class CityDTO {
    private Long id;
    private String name;
    private String continent;
    private String country;
    private String state;
    private List<HotelDTO> hotelList;
}
