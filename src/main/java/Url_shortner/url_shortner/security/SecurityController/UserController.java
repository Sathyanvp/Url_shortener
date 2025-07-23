package Url_shortner.url_shortner.security.SecurityController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Url_shortner.url_shortner.DTO.ErrorResponse;
import Url_shortner.url_shortner.security.SecurityDTO.LoginResponse;
import Url_shortner.url_shortner.security.SecurityDTO.RegisterResponse;
import Url_shortner.url_shortner.security.securityModel.Users;
import Url_shortner.url_shortner.security.securityService.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


@Tag(name = "Authentication", description = "User login and registration")
@RestController
public class UserController {

	
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
    
	
	@PostMapping("/register")
	@Operation(
	    summary = "Register a new user",
	    description = "Registers a user with a username and password",
	    responses = {
	        @ApiResponse(
	            responseCode = "201",
	            description = "User successfully registered",
	            content = @Content(
	                mediaType = "application/json",
	                schema = @Schema(implementation = RegisterResponse.class)
	            )
	        ),
	        @ApiResponse(
	            responseCode = "400",
	            description = "Invalid registration request",
	            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
	        )
	    }
	)
	public ResponseEntity<RegisterResponse> register(@RequestBody Users user) {
	    // Assume service call here
	    return ResponseEntity.status(HttpStatus.CREATED)
	                         .body(new RegisterResponse("201 CREATED", "Register successful"));
	}
	
	
	
	
	@PostMapping("/login")
	@Operation(summary = "Authenticate user and return JWT token")
	@ApiResponse(
	    responseCode = "200",
	    description = "JWT Token returned on successful login",
	    content = @Content(
	        mediaType = "application/json",
	        schema = @Schema(implementation = LoginResponse.class)
	    )
	)
	public ResponseEntity<LoginResponse> login(@RequestBody Users user) {
		 String token = service.verify(user);
		 LoginResponse response = new LoginResponse("200 OK", "Login successful", token);
		 return ResponseEntity.ok(response);
		
	}

}
