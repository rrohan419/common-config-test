package com.mb.common.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ValidatioErrorResponse {

	private String fieldName;
	
	private String message;
	
}
