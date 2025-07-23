package Url_shortner.url_shortner.security.SecurityDTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class RegisterResponse {

	   @Schema(description = "HTTP status", example = "200 OK")
	    private String statusCode;

	    @Schema(description = "Login result message", example = "Login successful")
	    private String message;
	    
	    
        public RegisterResponse(String statusCode, String message) {
			
			this.statusCode = statusCode;
			this.message = message;
		}
	    

		public String getStatusCode() {
			return statusCode;
		}

		public void setStatusCode(String statusCode) {
			this.statusCode = statusCode;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		
	    
}
