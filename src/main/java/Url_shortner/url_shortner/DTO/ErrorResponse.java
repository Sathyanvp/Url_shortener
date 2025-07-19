package Url_shortner.url_shortner.DTO;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;



public class ErrorResponse {
	
	private HttpStatus statusCode;
	private String message;
	private LocalDateTime timestamp;

    public ErrorResponse() {
		
	}


	public ErrorResponse(HttpStatus statusCode, String message, LocalDateTime timestamp) {
    	this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
        
    }
    
    
    public HttpStatus getStatusCode() {
  		return statusCode;
  	}

  	

	public void setStatusCode(HttpStatus statusCode) {
  		this.statusCode = statusCode;
  	}
  	
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Error [statusCode=" + statusCode + ", message=" + message + ", timestamp=" + timestamp + "]";
	}


}

 