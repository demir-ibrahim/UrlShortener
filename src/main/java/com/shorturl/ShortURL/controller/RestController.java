package com.shorturl.ShortURL.controller;

import com.shorturl.ShortURL.model.BitLyRequest;
import com.shorturl.ShortURL.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@Slf4j
@RequestMapping("/api/v1")
public class RestController {

    @Autowired
    Service service;

    @PostMapping("/process")
    public String processBitly(@RequestBody BitLyRequest bitLyRequest) {
        String shortURL = service.getShortURL(bitLyRequest.getLongURL());
        return shortURL;
    }
}
