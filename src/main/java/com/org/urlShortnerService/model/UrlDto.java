package com.org.urlShortnerService.model;

public class UrlDto {
	private String url;
	private int hit_count;
	//private String userName;
	
	public UrlDto() {		
	}
	
	public int getHit_count() {
		return hit_count;
	}

	public void setHit_count(int hit_count) {
		this.hit_count = hit_count;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public UrlDto(String url, int hit_count) {
		super();
		this.url = url;
		this.hit_count = hit_count;
	}

	@Override
	public String toString() {
		return "UrlDto [url=" + url + ", hit_count=" + hit_count + "]";
	}

//	public UrlDto(String url, String userName) {
//		super();
//		this.url = url;
//		//this.userName = userName;
//	}
//
//	@Override
//	public String toString() {
//		return "UrlDto [url=" + url +  "]";
//	}
	
}
