package com.shorturl.ShortURL.repository;


import com.shorturl.ShortURL.entity.ShortenedURL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortenedURLRepository extends JpaRepository <ShortenedURL, Long> {

}
