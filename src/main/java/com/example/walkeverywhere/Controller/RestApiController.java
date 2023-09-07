package com.example.walkeverywhere.Controller;


import com.example.walkeverywhere.domain.Location;
import com.example.walkeverywhere.domain.LocationMap;
import com.example.walkeverywhere.dto.LocationRequest;
import com.example.walkeverywhere.dto.ResponseDto;
import com.example.walkeverywhere.dto.TMapResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class RestApiController {
    private static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
    private ObjectMapper objectMapper= new ObjectMapper();


    @GetMapping("/newlocations")
    public ResponseDto<LocationMap> apiGetLocationWithAlgorithm(){//@RequestBody Location startlocation, Location endLocation
        String[] stringList = new String[2];
        Location[] locations = new Location[2];


        stringList[0] = "best";
        stringList[1] = "worst";


        Location tempLocation1 = new Location( 37.492268, 126.926672);
        Location tempLocation2 = new Location(37.491439, 126.925819);

        locations[0] = tempLocation1;
        locations[1] = tempLocation2;

        return new ResponseDto(HttpStatus.OK, new LocationMap(stringList, locations));
    }

//    @PostMapping("/directions")
//    public String apiGetDirections(@RequestBody LocationRequest request) throws Exception{
//
//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("AppKey", "XGhaa9RZwt8RNzEHSyVy63DuCRGxbdJP4jOiNID1");
//        String json = "{\"startX\":\"" + Double.toString(request.getStartLocation().getLongitude())+"\","+
//                        "\"startY\":\"" + Double.toString(request.getStartLocation().getLatitude()) +"\","+
//                        "\"endX\":\"" + Double.toString(request.getEndLocation().getLongitude()) +"\"," +
//                        "\"endY\":\"" +Double.toString(request.getEndLocation().getLatitude()) +"\"," +
//                        "\"count\" : 1,"+
//                        "\"lang\" :0," +
//                        "\"format\": \"json\""
//                        +"}";
//        logger.warn(json);
//        HttpEntity<String> entity = new HttpEntity<>(json, headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//                "https://apis.openapi.sk.com/transit/routes",
//                HttpMethod.POST,
//                entity,
//                String.class
//        );
//        String tmapResult = response.getBody();
//
//        TMapResponse tMapResponse = objectMapper.readValue(tmapResult, TMapResponse.class);
////        logger.info(Integer.toString(tMapResponse.getTotalTime()));
////        return Integer.toString(tMapResponse.getTotalTime());
//        return"";
//
//    }
//
//    @GetMapping("/test")
//    public void test() throws JsonProcessingException {
//        String testString = "{\n" +
//                "    \"metaData\": {\n" +
//                "        \"requestParameters\": {\n" +
//                "            \"busCount\": 1,\n" +
//                "            \"expressbusCount\": 0,\n" +
//                "            \"subwayCount\": 0,\n" +
//                "            \"airplaneCount\": 0,\n" +
//                "            \"locale\": \"ko\",\n" +
//                "            \"endY\": \"37.609094989686\",\n" +
//                "            \"endX\": \"127.030406594109\",\n" +
//                "            \"wideareaRouteCount\": 0,\n" +
//                "            \"subwayBusCount\": 0,\n" +
//                "            \"startY\": \"37.63788539420793\",\n" +
//                "            \"startX\": \"127.02550910860451\",\n" +
//                "            \"ferryCount\": 0,\n" +
//                "            \"trainCount\": 0,\n" +
//                "            \"reqDttm\": \"20221028152120\"\n" +
//                "        },\n" +
//                "        \"plan\": {\n" +
//                "            \"itineraries\": [\n" +
//                "                {\n" +
//                "                    \"fare\": {\n" +
//                "                        \"regular\": {\n" +
//                "                            \"totalFare\": 1200,\n" +
//                "                            \"currency\": {\n" +
//                "                                \"symbol\": \"￦\",\n" +
//                "                                \"currency\": \"원\",\n" +
//                "                                \"currencyCode\": \"KRW\"\n" +
//                "                            }\n" +
//                "                        }\n" +
//                "                    },\n" +
//                "                    \"totalTime\": 986,\n" +
//                "                    \"legs\": [\n" +
//                "                        {\n" +
//                "                            \"mode\": \"WALK\",\n" +
//                "                            \"sectionTime\": 110,\n" +
//                "                            \"distance\": 115,\n" +
//                "                            \"start\": {\n" +
//                "                                \"name\": \"출발지\",\n" +
//                "                                \"lon\": 127.02550910860451,\n" +
//                "                                \"lat\": 37.63788539420793\n" +
//                "                            },\n" +
//                "                            \"end\": {\n" +
//                "                                \"name\": \"수유역.강북구청\",\n" +
//                "                                \"lon\": 127.02612777777777,\n" +
//                "                                \"lat\": 37.638625\n" +
//                "                            },\n" +
//                "                            \"steps\": [\n" +
//                "                                {\n" +
//                "                                    \"streetName\": \"\",\n" +
//                "                                    \"distance\": 60,\n" +
//                "                                    \"description\": \"60m 이동\",\n" +
//                "                                    \"linestring\": \"127.02551,37.637882 127.02552,37.637897 127.025955,37.63829\"\n" +
//                "                                },\n" +
//                "                                {\n" +
//                "                                    \"streetName\": \"\",\n" +
//                "                                    \"distance\": 15,\n" +
//                "                                    \"description\": \"좌회전 후 15m 이동 \",\n" +
//                "                                    \"linestring\": \"127.025955,37.63829 127.025826,37.638374\"\n" +
//                "                                },\n" +
//                "                                {\n" +
//                "                                    \"streetName\": \"\",\n" +
//                "                                    \"distance\": 25,\n" +
//                "                                    \"description\": \"수유역  7번출구 에서 우회전 후 25m 이동 \",\n" +
//                "                                    \"linestring\": \"127.025826,37.638374 127.02598,37.638523 127.02597,37.63855\"\n" +
//                "                                },\n" +
//                "                                {\n" +
//                "                                    \"streetName\": \"도봉로\",\n" +
//                "                                    \"distance\": 15,\n" +
//                "                                    \"description\": \"수유역  8번출구 에서 우회전 후 도봉로 을 따라 15m 이동 \",\n" +
//                "                                    \"linestring\": \"127.02597,37.63855 127.02606,37.63864 127.02608,37.638657\"\n" +
//                "                                }\n" +
//                "                            ]\n" +
//                "                        },\n" +
//                "                        {\n" +
//                "                            \"mode\": \"BUS\",\n" +
//                "                            \"routeColor\": \"53B332\",\n" +
//                "                            \"sectionTime\": 710,\n" +
//                "                            \"route\": \"지선:1128\",\n" +
//                "                            \"distance\": 4118,\n" +
//                "                            \"start\": {\n" +
//                "                                \"name\": \"수유역.강북구청\",\n" +
//                "                                \"lon\": 127.02612777777777,\n" +
//                "                                \"lat\": 37.638625\n" +
//                "                            },\n" +
//                "                            \"passStopList\": {\n" +
//                "                                \"stationList\": [\n" +
//                "                                    {\n" +
//                "                                        \"index\": 0,\n" +
//                "                                        \"stationName\": \"수유역.강북구청\",\n" +
//                "                                        \"lon\": \"127.026128\",\n" +
//                "                                        \"lat\": \"37.638625\",\n" +
//                "                                        \"stationID\": \"777957\"\n" +
//                "                                    },\n" +
//                "                                    {\n" +
//                "                                        \"index\": 1,\n" +
//                "                                        \"stationName\": \"신일병원\",\n" +
//                "                                        \"lon\": \"127.022400\",\n" +
//                "                                        \"lat\": \"37.634719\",\n" +
//                "                                        \"stationID\": \"777816\"\n" +
//                "                                    },\n" +
//                "                                    {\n" +
//                "                                        \"index\": 2,\n" +
//                "                                        \"stationName\": \"강북노인종합복지관\",\n" +
//                "                                        \"lon\": \"127.018939\",\n" +
//                "                                        \"lat\": \"37.634439\",\n" +
//                "                                        \"stationID\": \"777807\"\n" +
//                "                                    },\n" +
//                "                                    {\n" +
//                "                                        \"index\": 3,\n" +
//                "                                        \"stationName\": \"화계사입구\",\n" +
//                "                                        \"lon\": \"127.017442\",\n" +
//                "                                        \"lat\": \"37.633333\",\n" +
//                "                                        \"stationID\": \"777743\"\n" +
//                "                                    },\n" +
//                "                                    {\n" +
//                "                                        \"index\": 4,\n" +
//                "                                        \"stationName\": \"빨래골입구.수유1동주민센터\",\n" +
//                "                                        \"lon\": \"127.017781\",\n" +
//                "                                        \"lat\": \"37.629700\",\n" +
//                "                                        \"stationID\": \"777597\"\n" +
//                "                                    },\n" +
//                "                                    {\n" +
//                "                                        \"index\": 5,\n" +
//                "                                        \"stationName\": \"롯데마트삼양점.래미안1차아파트\",\n" +
//                "                                        \"lon\": \"127.018200\",\n" +
//                "                                        \"lat\": \"37.625511\",\n" +
//                "                                        \"stationID\": \"777412\"\n" +
//                "                                    },\n" +
//                "                                    {\n" +
//                "                                        \"index\": 6,\n" +
//                "                                        \"stationName\": \"삼양초등학교\",\n" +
//                "                                        \"lon\": \"127.018967\",\n" +
//                "                                        \"lat\": \"37.623219\",\n" +
//                "                                        \"stationID\": \"777316\"\n" +
//                "                                    },\n" +
//                "                                    {\n" +
//                "                                        \"index\": 7,\n" +
//                "                                        \"stationName\": \"강북청소년문화정보도서관입구\",\n" +
//                "                                        \"lon\": \"127.020208\",\n" +
//                "                                        \"lat\": \"37.621769\",\n" +
//                "                                        \"stationID\": \"777266\"\n" +
//                "                                    },\n" +
//                "                                    {\n" +
//                "                                        \"index\": 8,\n" +
//                "                                        \"stationName\": \"삼양동사거리\",\n" +
//                "                                        \"lon\": \"127.021694\",\n" +
//                "                                        \"lat\": \"37.619169\",\n" +
//                "                                        \"stationID\": \"777176\"\n" +
//                "                                    },\n" +
//                "                                    {\n" +
//                "                                        \"index\": 9,\n" +
//                "                                        \"stationName\": \"성암국제무역고등학교\",\n" +
//                "                                        \"lon\": \"127.025514\",\n" +
//                "                                        \"lat\": \"37.617994\",\n" +
//                "                                        \"stationID\": \"777125\"\n" +
//                "                                    },\n" +
//                "                                    {\n" +
//                "                                        \"index\": 10,\n" +
//                "                                        \"stationName\": \"삼양동사거리입구\",\n" +
//                "                                        \"lon\": \"127.028500\",\n" +
//                "                                        \"lat\": \"37.617081\",\n" +
//                "                                        \"stationID\": \"777085\"\n" +
//                "                                    },\n" +
//                "                                    {\n" +
//                "                                        \"index\": 11,\n" +
//                "                                        \"stationName\": \"미아사거리역\",\n" +
//                "                                        \"lon\": \"127.029778\",\n" +
//                "                                        \"lat\": \"37.615453\",\n" +
//                "                                        \"stationID\": \"776989\"\n" +
//                "                                    },\n" +
//                "                                    {\n" +
//                "                                        \"index\": 12,\n" +
//                "                                        \"stationName\": \"미아사거리\",\n" +
//                "                                        \"lon\": \"127.030100\",\n" +
//                "                                        \"lat\": \"37.610197\",\n" +
//                "                                        \"stationID\": \"776703\"\n" +
//                "                                    }\n" +
//                "                                ]\n" +
//                "                            },\n" +
//                "                            \"end\": {\n" +
//                "                                \"name\": \"미아사거리\",\n" +
//                "                                \"lon\": 127.0301,\n" +
//                "                                \"lat\": 37.61019722222222\n" +
//                "                            },\n" +
//                "                            \"type\": 12,\n" +
//                "                            \"passShape\": {\n" +
//                "                                \"linestring\": \"127.026156,37.638594 127.023856,37.636456 127.023564,37.636175 127.023394,37.635961 127.023297,37.635803 127.023189,37.635550 127.023156,37.635389 127.023142,37.635278 127.023181,37.634889 127.023194,37.634747 127.022425,37.634689 127.019519,37.634467 127.018919,37.634406 127.017581,37.634272 127.017417,37.634108 127.017489,37.633333 127.017694,37.631122 127.017714,37.630742 127.017825,37.629694 127.017825,37.629681 127.017975,37.627683 127.018242,37.625522 127.018311,37.624953 127.018331,37.624858 127.018428,37.624167 127.018519,37.623883 127.018594,37.623744 127.018847,37.623408 127.018997,37.623250 127.019994,37.622169 127.020239,37.621797 127.020242,37.621789 127.020361,37.621525 127.020956,37.619597 127.021075,37.619464 127.021208,37.619353 127.021692,37.619203 127.022906,37.618833 127.023528,37.618581 127.023875,37.618458 127.024317,37.618328 127.025514,37.618033 127.025547,37.618019 127.025772,37.617919 127.026206,37.617703 127.027153,37.617178 127.027200,37.617167 127.028514,37.617117 127.029708,37.617069 127.029764,37.616783 127.029781,37.616036 127.029825,37.615453 127.030019,37.612792 127.030094,37.612286 127.030233,37.611583 127.030267,37.611283 127.030258,37.610969 127.030189,37.610178\"\n" +
//                "                            }\n" +
//                "                        },\n" +
//                "                        {\n" +
//                "                            \"mode\": \"WALK\",\n" +
//                "                            \"sectionTime\": 166,\n" +
//                "                            \"distance\": 152,\n" +
//                "                            \"start\": {\n" +
//                "                                \"name\": \"미아사거리\",\n" +
//                "                                \"lon\": 127.0301,\n" +
//                "                                \"lat\": 37.61019722222222\n" +
//                "                            },\n" +
//                "                            \"end\": {\n" +
//                "                                \"name\": \"도착지\",\n" +
//                "                                \"lon\": 127.030406594109,\n" +
//                "                                \"lat\": 37.609094989686\n" +
//                "                            },\n" +
//                "                            \"steps\": [\n" +
//                "                                {\n" +
//                "                                    \"streetName\": \"도봉로\",\n" +
//                "                                    \"distance\": 107,\n" +
//                "                                    \"description\": \"도봉로 을 따라 107m 이동\",\n" +
//                "                                    \"linestring\": \"127.03003,37.610203 127.03001,37.610046 127.03001,37.610027 127.03001,37.609997 127.02998,37.60989 127.029945,37.609604 127.02994,37.609585 127.02993,37.60957 127.02989,37.609333 127.02988,37.609264 127.02987,37.60925\"\n" +
//                "                                },\n" +
//                "                                {\n" +
//                "                                    \"streetName\": \"\",\n" +
//                "                                    \"distance\": 14,\n" +
//                "                                    \"description\": \"세사리빙 미아점 에서 좌측 횡단보도 후 14m 이동 \",\n" +
//                "                                    \"linestring\": \"127.02987,37.60925 127.03002,37.60922\"\n" +
//                "                                },\n" +
//                "                                {\n" +
//                "                                    \"streetName\": \"\",\n" +
//                "                                    \"distance\": 15,\n" +
//                "                                    \"description\": \"우회전 후 15m 이동 \",\n" +
//                "                                    \"linestring\": \"127.03002,37.60922 127.03007,37.609154 127.03014,37.609177\"\n" +
//                "                                },\n" +
//                "                                {\n" +
//                "                                    \"streetName\": \"보행자도로\",\n" +
//                "                                    \"distance\": 16,\n" +
//                "                                    \"description\": \"횡단보도 후 보행자도로 을 따라 16m 이동 \",\n" +
//                "                                    \"linestring\": \"127.03014,37.609177 127.03029,37.60925\"\n" +
//                "                                }\n" +
//                "                            ]\n" +
//                "                        }\n" +
//                "                    ],\n" +
//                "                    \"totalWalkTime\": 276,\n" +
//                "                    \"transferCount\": 0,\n" +
//                "                    \"totalDistance\": 4343,\n" +
//                "                    \"pathType\": 2,\n" +
//                "                    \"totalWalkDistance\": 267\n" +
//                "                }\n" +
//                "            ]\n" +
//                "        }\n" +
//                "    }\n" +
//                "}";
//
//
//        TMapResponse tMapResponse = objectMapper.readValue(testString, TMapResponse.class);
//        logger.info(Integer.toString(tMapResponse.metaData.plan.itineraries));
//    }

}
