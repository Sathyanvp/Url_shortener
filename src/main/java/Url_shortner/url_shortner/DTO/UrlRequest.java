package Url_shortner.url_shortner.DTO;




 

public class UrlRequest {
	
	private String orginalUrl;
	private String coustomAlais;
	private String domain;
	

	public UrlRequest() {
		
	}
	


	public String getDomain() {
		return domain;
	}



	public void setDomain(String domain) {
		this.domain = domain;
	}



	public String getCoustomAlais() {
		return coustomAlais;
	}


	public void setCoustomAlais(String coustomAlais) {
		this.coustomAlais = coustomAlais;
	}



	public String getOrginalUrl() {
		return orginalUrl;
	}

	public void setOrginalUrl(String orginalUrl) {
		this.orginalUrl = orginalUrl;
		
	}
  

	

}
