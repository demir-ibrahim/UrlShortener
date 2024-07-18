package com.shorturl.ShortURL.service;

import com.opsmatters.bitly.Bitly;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
import com.shorturl.ShortURL.entity.ShortenedURL;
import com.shorturl.ShortURL.repository.ShortenedURLRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@org.springframework.stereotype.Service
public class Service {
    @Value("${BITLY_TOKEN}")
    String BITLY_TOKEN;

    @Autowired
    private ShortenedURLRepository shortenedURLRepository;

    private Bitly client;

    @PostConstruct
    public void setup() {
        client = new Bitly(BITLY_TOKEN);
    }

    public String getShortURL(String longURL) {
        String link = "error";
        try {
            CreateBitlinkResponse response = client.bitlinks().shorten(longURL).get();

            link = response.getLink();

            ShortenedURL shortenedURL = new ShortenedURL();
            shortenedURL.setLongURL(longURL);
            shortenedURL.setShortURL(link);
            shortenedURLRepository.save(shortenedURL);

            link = "URL Shortener ile dönüştürülmüş Linkiniz Data kaydı tamamlanmıştır => " + link;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return link;
    }
}