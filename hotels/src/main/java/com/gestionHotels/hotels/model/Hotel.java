package com.gestionHotels.hotels.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class Hotel {
    private Long id;
    private String name;
    private int stars;
    private Long city_id;
}
