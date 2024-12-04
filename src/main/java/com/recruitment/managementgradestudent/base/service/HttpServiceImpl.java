package com.recruitment.managementgradestudent.base.service;

import com.recruitment.managementgradestudent.base.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class HttpServiceImpl implements HttpService {

	@Override
	public ResponseEntity<String> getSuccessResponse(String message) {
		return new ResponseEntity<String>(new ResponseDto<String>(message).toString(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> getStatusResponse(HttpStatus httpStatus) {
		return new ResponseEntity<String>(new ResponseDto<String>(httpStatus.name(), Collections.singletonList(httpStatus.getReasonPhrase())).toString(), httpStatus);
	}

	@Override
	public ResponseEntity<String> getResponseEntity(ResponseDto<?> response) {
		return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> getResponseEntity(ResponseDto<?> response, HttpStatus httpStatus) {
		return new ResponseEntity<String>(response.toString(), httpStatus);
	}
	
}
