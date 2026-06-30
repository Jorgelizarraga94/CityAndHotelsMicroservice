package com.gestionHotels.cities.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class City {
    private Long id;
    private String name;
    private String continent;
    private String country;
    private String state;
}
