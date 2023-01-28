package com.mb.common.util;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.mb.common.model.ErrorResponse;
import com.mb.common.model.SuccessResponse;
import com.mb.common.model.ValidatioErrorResponse;


@Component
public class ResponseMaker {

	private Logger logger = LogManager.getLogger();

	/**
	 * Custom success response object
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @param <T>
	 * @param message
	 * @param data
	 * @return {@link SuccessResponse}
	 */
	public <T> ResponseEntity<SuccessResponse<T>> successResponse(String message, T data) {

		SuccessResponse<T> response = new SuccessResponse<>(message, HttpStatus.OK.value(), data, false, new Date());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Custom error response object when any exception occurs in application
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com]
	 * @param <T>
	 * @param message
	 * @param errorCode
	 * @return {@link ErrorResponse}
	 */
	public ResponseEntity<ErrorResponse> errorResponse(String message, Integer errorCode) {

		ErrorResponse response = new ErrorResponse(message, errorCode, true, new Date(), null, null);

		logger.error(response);
		return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode));
	}

	/**
	 * Custom validation error response object when validations failed
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @param <T>
	 * @param message
	 * @param errorCode
	 * @param validationErros
	 * @return {@link ErrorResponse}
	 */
	public ResponseEntity<Object> validationErrorResponse(String message, Integer errorCode,
			List<ValidatioErrorResponse> validationErros) {

		ErrorResponse response = new ErrorResponse(message, errorCode, true, new Date(), validationErros, null);

		logger.error(response);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Custom error response object for sending data
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @param <T>
	 * @param message
	 * @param errorCode
	 * @param data
	 * @return {@link ErrorResponse}
	 */
	public ResponseEntity<ErrorResponse> dataObjectErrorResponse(String message, Integer errorCode, Object data) {

		ErrorResponse response =  new ErrorResponse(message, errorCode, true, new Date(), data);

		logger.error(response);
		return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode));
	}
}
