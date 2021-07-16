package com.org.urlShortnerService.model;

public class UrlResponseDto {
	private String originalUrl;
	private String shortLink;
	 
	public UrlResponseDto() {
		
	}
	
	
	public UrlResponseDto(String originalUrl, String shortLink) {
		super();
		this.originalUrl = originalUrl;
		this.shortLink = shortLink;
	}
	
	public String getOriginalUrl() {
		return originalUrl;
	}
	
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public String getShortLink() {
		return shortLink;
	}
	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}
	
	@Override
	public String toString() {
		return "UrlResponseDto [originalUrl=" + originalUrl + ", shortLink=" + shortLink + "]";
	}
	
	
}
