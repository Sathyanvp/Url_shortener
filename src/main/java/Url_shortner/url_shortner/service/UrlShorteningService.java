package Url_shortner.url_shortner.service;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import Url_shortner.url_shortner.DTO.ErrorResponse;
import Url_shortner.url_shortner.DTO.StatResponse;
import Url_shortner.url_shortner.DTO.UrlRequest;
import Url_shortner.url_shortner.entity.Url;
import Url_shortner.url_shortner.repository.UrlRepository;


@Service
public class UrlShorteningService {
	private UrlRepository urlRepository;
	private  UrlValidator urlValidator;
    private BaseConverter convertor;
    @Value("${app.short-url-domain}")
    private String shortUrlDomain;

    
    @Autowired
    public UrlShorteningService(UrlRepository urlRepository, BaseConverter convertor) {
        this.urlRepository = urlRepository;
        this.convertor = convertor;
        this.urlValidator = new UrlValidator(new String[]{"http", "https"});
    }



    
	public boolean isValidUrl(String url) {
	    return urlValidator.isValid(url);
	}

	public ResponseEntity<?> convertUrl(UrlRequest urlRequest) {
		 
		Url urlobj = urlRepository.findByOriginalUrl(urlRequest.getOriginalUrl());
		if(urlobj != null) {
			
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(shortUrlDomain + "/" + urlobj.getShortUrl());
			
		}
		
		Url newUrl = new Url();
	    newUrl.setOriginalUrl(urlRequest.getOriginalUrl());
	    newUrl.setCreatedAt(LocalDateTime.now());
	    newUrl.setExpiryDate(LocalDateTime.now().plusDays(30));
	    String shortCode = urlRequest.getCoustomAlais();
	    if (shortCode == null || shortCode.isEmpty()) {
	        shortCode = convertor.generateShortUrl();
	    }

	    while(true) {
	    	if(urlRepository.findByShortUrl(shortCode) == null) { break;}
	    }
	    
	    newUrl.setShortUrl(shortCode);
	    urlRepository.save(newUrl); 

	    return ResponseEntity
	           .status(HttpStatus.CREATED)
	           .body(shortUrlDomain + "/" + shortCode);
		
	}

	public ResponseEntity<?> redirectUrl(String shortUrl) {
		Url redirectUrl = urlRepository.findByShortUrl(shortUrl);
		
		if(redirectUrl == null) {
			throw new IllegalArgumentException("Short url not found");
			
		}
		
		if (redirectUrl.getExpiryDate().isBefore(LocalDateTime.now())) {
		      throw new IllegalStateException("This URL has expired.");
		      
		    }
		redirectUrl.setClickCount(redirectUrl
				.getClickCount() + 1);
		
		urlRepository.save(redirectUrl);
		
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.location(URI
						.create(redirectUrl
						.getOriginalUrl()))
				.build();
	}



	public StatResponse getStatistics(String shortUrl) {
		Url stat = urlRepository.findByShortUrl(shortUrl);

		if(stat == null) {
			throw new IllegalArgumentException("Short url not found");
		    }
		
		
		return new StatResponse(
				stat.getOriginalUrl(),
				stat.getShortUrl(),
				stat.getCreatedAt(),
				stat.getExpiryDate(),
				stat.getClickCount());
				
	}
	
	
	
	@Scheduled(cron = "0 0 0 * * *") 
	public void deleteExpiredUrl() {
		
		    List<Url> expired = urlRepository.findByExpiryDateBefore(LocalDateTime.now());
		    urlRepository.deleteAll(expired);

	}

}
