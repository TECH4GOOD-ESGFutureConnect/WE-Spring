package com.example.walkeverywhere.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class LocationMap {
    private HashMap<String, Location> locationMap;

    @Builder
    public LocationMap(String[] nodeList, Location[]locations){
        this.locationMap = new HashMap<String, Location>();
        for(int i = 0; i < nodeList.length; i++){
            locationMap.put(nodeList[i], locations[i]);
        }

    }

}
