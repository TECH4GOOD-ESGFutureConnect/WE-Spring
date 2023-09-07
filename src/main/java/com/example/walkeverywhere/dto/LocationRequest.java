package com.example.walkeverywhere.dto;

import com.example.walkeverywhere.domain.Location;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LocationRequest {
    private Location startLocation;
    private Location endLocation;
}
