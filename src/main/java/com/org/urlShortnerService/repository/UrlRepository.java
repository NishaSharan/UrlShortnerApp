package com.org.urlShortnerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.urlShortnerService.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long>{
	public Url findByShortLink(String shortLink);
	public Url findByOriginalUrl(String originalLink);
}