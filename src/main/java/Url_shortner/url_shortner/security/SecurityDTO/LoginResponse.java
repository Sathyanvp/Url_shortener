package Url_shortner.url_shortner.security.SecurityDTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class LoginResponse {

    @Schema(description = "HTTP status", example = "200 OK")
    private String statusCode;

    @Schema(description = "Login result message", example = "Login successful")
    private String message;

    @Schema(description = "JWT token for authenticated access", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String token;

	public LoginResponse(String statusCode, String message, String token) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.token = token;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

   
}
