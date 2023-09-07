package com.example.walkeverywhere.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {

    HttpStatus status;
    T data;

}
