package com.recruitment.managementgradestudent.base.service;


import com.recruitment.managementgradestudent.base.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface HttpService {
	public ResponseEntity<String> getSuccessResponse(String message);
	public ResponseEntity<String> getStatusResponse(HttpStatus httpStatus);
	public ResponseEntity<String> getResponseEntity(ResponseDto<?> response);

	public ResponseEntity<String> getResponseEntity(ResponseDto<?> response, HttpStatus httpStatus);

}
