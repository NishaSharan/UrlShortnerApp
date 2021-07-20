package com.org.urlShortnerService.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.urlShortnerService.model.Url;
import com.org.urlShortnerService.model.UrlDto;
import com.org.urlShortnerService.model.UrlErrorResponseDto;
import com.org.urlShortnerService.model.UrlResponseDto;
import com.org.urlShortnerService.service.UrlService;

@RestController
public class UrlShorteningController {
	@Autowired
	private UrlService urlService;
	
	@PostMapping("/generate")
	public ResponseEntity<?> generateShortLink(@RequestBody UrlDto urlDto)
	{
		Url urlToRet = urlService.generateShortLink(urlDto);
		
		if (urlToRet !=null)
		{
			UrlResponseDto urlResponseDto = new UrlResponseDto();
			urlResponseDto.setOriginalUrl(urlToRet.getOriginalUrl());
			urlResponseDto.setShortLink(urlToRet.getShortLink());
			urlResponseDto.setUrlHitsCount(urlToRet.getUrlHitsCount());
			return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);
		}
		
		UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
		urlErrorResponseDto.setStatus("404");
		urlErrorResponseDto.setError("There was an error processing your request. Please try again!");
		return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/{shortLink}")
	public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response) throws IOException{
		
		if(StringUtils.isEmpty(shortLink)) {
			UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
			urlErrorResponseDto.setError("Invalid URL");
			urlErrorResponseDto.setStatus("404");
			return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
		}
		
		Url urlToRet = urlService.getEncodedUrl(shortLink);
		
		
		if(urlToRet == null)
		{
			UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
			urlErrorResponseDto.setError("URL does not exist!");
			urlErrorResponseDto.setStatus("400");
			return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
		}	
		
		int URLHits = urlToRet.getUrlHitsCount();
		System.out.println("---------URLHits before increment---------"+ URLHits);
		urlToRet.setUrlHitsCount(URLHits++);
		System.out.println("---------URLHits after increment---------"+ URLHits);
		
		response.sendRedirect(urlToRet.getOriginalUrl());
		return null;
		
	}
	
	@DeleteMapping("/delete")
	public void deleteShortUrl(@RequestBody UrlDto urlDto) {
		String originalUrl = urlDto.getUrl();
		
		urlService.deleteShortLink(originalUrl);
		
	}	

}
