package com.org.urlShortnerService.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;
import com.org.urlShortnerService.model.Url;
import com.org.urlShortnerService.model.UrlDto;
import com.org.urlShortnerService.repository.UrlRepository;


@Component
public class UrlServiceImpl implements UrlService{

	@Autowired
	private UrlRepository urlRepository;
	
	@Override
	public Url generateShortLink(UrlDto urlDto) {
		if(StringUtils.isNotEmpty(urlDto.getUrl()))
		{
			String encodedUrl = encodedUrl(urlDto.getUrl());
			Url urlToPersist = new Url();
			urlToPersist.setOriginalUrl(urlDto.getUrl());
			urlToPersist.setShortLink(encodedUrl);
			urlToPersist.setCreationDate(LocalDateTime.now());
			Url urlToRet = persistShortLink(urlToPersist);
			
			if(urlToRet!=null)
				return urlToRet;
			
			return null;
		}
		return null;
	}

	private String encodedUrl(String url) {
		String encodedUrl = "";
		LocalDateTime time = LocalDateTime.now();
		encodedUrl = Hashing.murmur3_32()
				.hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
				.toString();
		return encodedUrl;
	}

	@Override
	public Url persistShortLink(Url url) {
		Url urlToRet = urlRepository.save(url);
		return urlToRet;
	}

	@Override
	public Url getEncodedUrl(String url) {
		Url urlToRet = urlRepository.findByShortLink(url);
		return urlToRet;
	}

	@Override
	public void deleteShortLink(String url) {		
		Url urlToDelete = urlRepository.findByOriginalUrl(url);		
		urlRepository.delete(urlToDelete);
	}

}
