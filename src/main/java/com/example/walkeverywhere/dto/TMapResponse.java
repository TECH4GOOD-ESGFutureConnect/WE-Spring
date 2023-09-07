package com.example.walkeverywhere.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TMapResponse {
    @JsonIgnore
    public MetaData metaData;



}
class MetaData{
    @JsonIgnore
    public RequestParameters requestParameters;

    public Plan plan;
}

class RequestParameters{
    // 필요한 변수만 정의
    @JsonIgnore
    public int busCount;
    @JsonIgnore
    public int expressbusCount;
    @JsonIgnore
    public int subwayCount;
    @JsonIgnore
    public int airplaneCount;
    @JsonIgnore
    public String locale;
    @JsonIgnore
    public String endY;
    @JsonIgnore
    public String endX;
    @JsonIgnore
    public int wideareaRouteCount;
    @JsonIgnore
    public int subwayBusCount;
    @JsonIgnore
    public String startY;
    @JsonIgnore
    public String startX;
    @JsonIgnore
    public int ferryCount;
    @JsonIgnore
    public int trainCount;
    @JsonIgnore
    public String reqDttm;
}

class Plan {
    public Itineraries itineraries;
};

class Itineraries{
    public int totalTime;

}