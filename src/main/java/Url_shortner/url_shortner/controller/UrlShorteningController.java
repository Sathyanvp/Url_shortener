package Url_shortner.url_shortner.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Url_shortner.url_shortner.DTO.ErrorResponse;
import Url_shortner.url_shortner.DTO.UrlRequest;
import Url_shortner.url_shortner.service.UrlShorteningService;

@RestController
public class UrlShorteningController {
    
	private UrlShorteningService service;

	
	
	public UrlShorteningController() {
	
	}

    @Autowired
	public UrlShorteningController(UrlShorteningService service) {
		
		this.service = service;
	}


	@PostMapping("/converturl")
	public ResponseEntity<?> createShortUrl (@RequestBody UrlRequest urlrequest){
		String originalUrl = urlrequest.getOrginalUrl();
		if(!service.isValidUrl(originalUrl)) {
			ErrorResponse errorResponse = new ErrorResponse( HttpStatus.BAD_REQUEST, "URL Entered Is Not A Valid Http or Https URL", LocalDateTime.now());
		    return ResponseEntity
				    .status(HttpStatus.BAD_REQUEST)
				    .body(errorResponse.toString());

		}
		
		return service.convertUrl(originalUrl);
	}
	
	
	@GetMapping("/{shortUrl}")
	public ResponseEntity<?> redirect (@PathVariable String shortUrl){
		
		 return service.redirectUrl(shortUrl);
		 }
	
	
	@GetMapping("/stat/{shortUrl}")
	public ResponseEntity<?> showStatistics (@PathVariable String shortUrl){
		return service.getStatistics(shortUrl);
		
	}
	
}
