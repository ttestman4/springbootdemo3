package com.example.demo3;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpHeaders;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.reactive.function.client.WebClient;

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

    @GetMapping("/quote3")
    public Object quote3() {
        String url = "https://quoters.apps.pcfone.io/api/random";
        return restTemplate.getForObject(url, Object.class);
    }

    @GetMapping("/quote4/**")
    public Object quote4(HttpServletRequest request) {
        WebClient webClient = WebClient.builder().baseUrl("https://quoters.apps.pcfone.io/").build();
        String requestUrl = request.getRequestURI();
        return webClient.get().uri(requestUrl.replace("/quote4", "")).retrieve().bodyToMono(Object.class);
    }

    // @RequestMapping("/**")
    // public ResponseEntity mirrorRest(@RequestBody(required = false) String body,
    // HttpMethod method,
    // HttpServletRequest request, HttpServletResponse response) throws
    // URISyntaxException {
    // String requestUrl = request.getRequestURI();

    // URI uri = new URI("http", null, server, port, null, null, null);
    // uri =
    // UriComponentsBuilder.fromUri(uri).path(requestUrl).query(request.getQueryString()).build(true).toUri();

    // HttpHeaders headers = new HttpHeaders();
    // Enumeration<String> headerNames = request.getHeaderNames();
    // while (headerNames.hasMoreElements()) {
    // String headerName = headerNames.nextElement();
    // headers.set(headerName, request.getHeader(headerName));
    // }

    // HttpEntity<String> httpEntity = new HttpEntity<>(body, headers);
    // RestTemplate restTemplate = new RestTemplate();
    // try {
    // return restTemplate.exchange(uri, method, httpEntity, String.class);
    // } catch (HttpStatusCodeException e) {
    // return
    // ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
    // .body(e.getResponseBodyAsString());
    // }
    // }
}
