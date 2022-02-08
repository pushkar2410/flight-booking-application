package com.flightapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorResponseModel {
	private String message;
    private Long errorTime;
    private Integer statusCode;
}
