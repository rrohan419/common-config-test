package com.mb.common.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mb.common.constant.ExceptionMessage;
import com.mb.common.model.ErrorResponse;
import com.mb.common.model.ValidatioErrorResponse;
import com.mb.common.util.ResponseMaker;


@RestControllerAdvice
public class GlobleExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private ResponseMaker responseMaker;

	@Autowired
	private Environment env;

	/**
	 * Used to catch custom exception
	 * 
	 * @param customException
	 * @return {@link ErrorResponse}
	 */
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> customExceptionHandler(CustomException customException) {

		return responseMaker.errorResponse(customException.getMessage(), customException.getErrorCode());
	}

	/**
	 * Used to catch null pointer exception
	 * 
	 * @param customException
	 * @return {@link ErrorResponse}
	 */
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorResponse> nullPointerHandler(NullPointerException nullPointerException) {

		nullPointerException.printStackTrace();
		return responseMaker.errorResponse(env.getProperty(ExceptionMessage.INTERNAL_SERVER_ERROR),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	/**
	 * Handling of validation exception and sending custom error response
	 * 
	 * @param customException
	 * @return {@link ErrorResponse}
	 */
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException argumentNotValidException, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		List<ValidatioErrorResponse> validationErros = argumentNotValidException.getBindingResult().getFieldErrors()
				.stream().map(f -> new ValidatioErrorResponse(f.getField(), f.getDefaultMessage()))
				.collect(Collectors.toList());

		return responseMaker.validationErrorResponse(env.getProperty(ExceptionMessage.INVALID_REQUEST_BODY),
				HttpStatus.BAD_REQUEST.value(), validationErros);
	}

}