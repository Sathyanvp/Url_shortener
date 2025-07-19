package Url_shortner.url_shortner.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class BaseConverter {
    
	private static final char[] baseCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	private final int base = 62;
	private Random random = new Random();
	public BaseConverter() {

	}

	public String generateShortUrl() {
		
		StringBuilder shortUrl = new StringBuilder();
		
		for(int i = 0 ; i < 6 ; i++) {
			shortUrl.append(baseCharacters[random.nextInt(base)]);
		}
		
		
		return shortUrl
				.reverse()
				.toString();

		
	}
	
	    
}