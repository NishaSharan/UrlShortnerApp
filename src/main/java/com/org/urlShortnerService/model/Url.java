package com.org.urlShortnerService.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Url {
	@Id
	@GeneratedValue
	private long id;
	@Lob // this will be a long URL
	private String originalUrl;
	private String shortLink;
	private int urlHitsCount;
	
	public int getUrlHitsCount() {
		return urlHitsCount;
	}

	public void setUrlHitsCount(int urlHitsCount) {
		this.urlHitsCount = urlHitsCount;
		//this.urlHitsCount = urlHitsCount++;
	}

	//private String userName;
	private LocalDateTime creationDate;
	
	public Url(){		
	}
	
//	public Url(long id, String originalUrl, String shortLink,String userName, LocalDateTime creationDate) {
//		super();
//		this.id = id;
//		this.originalUrl = originalUrl;
//		this.shortLink = shortLink;
//		this.creationDate = creationDate;
//		//this.userName = userName;
//	}
	
	public long getId() {
		return id;
	}
	public Url(long id, String originalUrl, String shortLink, int urlHitsCount, LocalDateTime creationDate) {
		super();
		this.id = id;
		this.originalUrl = originalUrl;
		this.shortLink = shortLink;
		this.urlHitsCount = urlHitsCount+1;
		this.creationDate = creationDate;
	}

	public void setId(long id) {
		this.id = id;
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
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Url [id=" + id + ", originalUrl=" + originalUrl + ", shortLink=" + shortLink +", urlHitsCount=" + urlHitsCount + ", creationDate=" + creationDate + "]";
	}

	
	
	
	

}
