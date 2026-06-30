package com.gestionHotels.cities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class HotelDTO {
    private Long id;
    private String name;
    private int stars;
    private Long city_id;
}
