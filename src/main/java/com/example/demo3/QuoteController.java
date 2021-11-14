package com.example.demo3;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpHeaders;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class QuoteController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/quote1")
    public Quote quote1() {
        String url = "https://quoters.apps.pcfone.io/api/random";
        RestTemplate restTemplate1 = new RestTemplate();
        Quote result = restTemplate1.getForObject(url, Quote.class);
        return result;
    }

    @GetMapping("/quote2")
    public Quote quote2() {
        String url = "https://quoters.apps.pcfone.io/api/random";
        Quote result = restTemplate.getForObject(url, Quote.class);
        return result;
    }
    
}
