package com.example.walkeverywhere.domain;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private double latitude;
    private double longitude;

//    @Builder
//    public Location(double latitude, double longitude){
//        this.latitude = latitude;
//        this.longitude = longitude;
//    }
}
