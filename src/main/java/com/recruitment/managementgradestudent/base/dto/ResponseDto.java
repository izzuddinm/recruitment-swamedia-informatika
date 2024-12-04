package com.recruitment.managementgradestudent.base.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class ResponseDto<T> {

	@JsonIgnore
	private ObjectMapper objectMapper = new ObjectMapper();
	private boolean success = false;
	private String message;
	private List<T> data = new ArrayList<T>();
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss z", timezone="UTC")
	private Date timestamp;
	
	public ResponseDto() {
		this.success = true;
	}
	
	public ResponseDto(String message) {
		this.success = true;
		this.message = message;
	}
	
	public ResponseDto(String message, List<T> data) {
		this.success = true;
		this.message = message;
		this.data = data;
	}
	
	public ResponseDto(List<T> data) {
		this.success = true;
		this.data = data;
	}
	public Date getTimestamp() {
		return new Date();
	}
	
	public void addData(T data) {
		this.data.add(data);
	}

	public String toString() {
		String json = "{\"success\":false,\"error\":{\"code\":\"INTERNAL_SERVER_ERROR\",\"message\":\"Internal Server Error\"}}";
		try {
			json = objectMapper.writeValueAsString(this);
		} catch(Exception e) {
			log.error("Error when parsing response model.", e);
		}
		return json;
	}
	
}
