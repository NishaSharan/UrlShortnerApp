package com.org.urlShortnerService.service;

import org.springframework.stereotype.Service;

import com.org.urlShortnerService.model.Url;
import com.org.urlShortnerService.model.UrlDto;

@Service
public interface UrlService {
	public Url generateShortLink(UrlDto urlDto);
	public Url persistShortLink(Url url);
	public Url getEncodedUrl(String url);
	public void deleteShortLink(String url);

}
