package com.mb.common.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

	private String message;
	
	private Integer code;
	
	private Boolean error;
	
	private Date timestamp;
	
	private Object data;
	
	private List<ValidatioErrorResponse> validationErros;

	public ErrorResponse(String message, Integer code, Boolean error, Date timestamp, Object data) {
		super();
		this.message = message;
		this.code = code;
		this.error = error;
		this.timestamp = timestamp;
		this.data = data;
	}

	
	
}
