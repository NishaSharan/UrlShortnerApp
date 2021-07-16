package com.org.urlShortnerService.model;

public class UrlDto {
	private String url;
	//private String userName;
	
	public UrlDto() {		
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public UrlDto(String url, String userName) {
		super();
		this.url = url;
		//this.userName = userName;
	}

	@Override
	public String toString() {
		return "UrlDto [url=" + url +  "]";
	}
	
}
