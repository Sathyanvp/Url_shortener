package Url_shortner.url_shortner.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Url {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@Column
	private String originalUrl;
    
	@Column
	private String shortUrl;
	
	@Column
	private String domain;
    
	@Column(nullable=false)
	private LocalDateTime createdAt;
    
	@Column(nullable=false)
	private LocalDateTime expiryDate;
	
	@Column
    private int clickCount;
	

	
	public Url() {
		
	}

	
    
    public Url(String originalUrl, String shortUrl) {
		
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
		this.clickCount = 0;
		
	}
    
    
	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}



	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}



	public void setId(int id) {
		this.id = id;
	}

	
    public String getOriginalUrl() {
		return originalUrl;
	}


	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}


	public String getShortUrl() {
		return shortUrl;
	}


	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}


	public int getClickCount() {
		return clickCount;
	}


	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
	
	
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	public int getId() {
		return id;
	}

	
	@Override
	public String toString() {
		return "Url [id=" + id + ", originalUrl=" + originalUrl + ", shortUrl=" + shortUrl + ", createdAt=" + createdAt
				+ ", ClickCount=" + clickCount + "]";
	}



	





    
}
