package Url_shortner.url_shortner.DTO;

import java.time.LocalDateTime;




public class StatResponse {
	
	
	private String originalUrl;
    private String shortUrl;
    private LocalDateTime createdAt;
    private LocalDateTime expiryDate;
	private int clickCount;
	
	public StatResponse(String originalUrl, String shortUrl, LocalDateTime createdAt, LocalDateTime  expiryDate, int clickCount) {
	
		this.originalUrl = originalUrl;
		this.shortUrl = shortUrl;
		this.createdAt = createdAt;
		this.expiryDate = expiryDate;
		this.clickCount = clickCount;
	}
	
    public LocalDateTime getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	
    public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOrginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public int getClickCount() {
		return clickCount;
	}
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
	
	@Override
	public String toString() {
		return "StatResponse [originalUrl=" + originalUrl + ", shortUrl=" + shortUrl + ", createdAt=" + createdAt
				+ ", expiryDate=" + expiryDate + ", clickCount=" + clickCount + "]";
	}
    
}
