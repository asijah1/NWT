package com.projekat.Katalog.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ApiError {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private HttpStatus status;
    private String message;
    private List<String> errors;
	private String debugMessage;
 
    private ApiError() {
        timestamp = LocalDateTime.now();
    }
    
    public ApiError(HttpStatus status) {
        super();
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
    
    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.setStatus(status);
        this.setMessage(message);
        this.setErrors(errors);
        this.timestamp = LocalDateTime.now();
    }
 
    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.setStatus(status);
        this.setMessage(message);
        this.timestamp = LocalDateTime.now();
        setErrors(Arrays.asList(error));
    }
    
    public ApiError(HttpStatus status, String message, Throwable ex) {
        super();
        this.setStatus(status);
        this.setMessage(message);
        this.timestamp = LocalDateTime.now();
        this.setDebugMessage(ex.getLocalizedMessage());
    }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}
	
}
