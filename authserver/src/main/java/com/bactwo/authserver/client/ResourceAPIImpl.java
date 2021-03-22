package com.bactwo.authserver.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Component
public class ResourceAPIImpl implements ResourceAPI {
    
    private final RestTemplate restTemplate;

    @Autowired
    public ResourceAPIImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> ResponseEntity<T> exchangeRemotePostOrPut(String baseUrl, String path, HttpMethod method, Object object,
                                                         Class<T> responseType) {
        URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(path)
                .build()
                .toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(object, headers);
        return restTemplate.exchange(builder, method, requestEntity, responseType);
    }

    @Override
    public <T> ResponseEntity<T> exchangeRemoteGetOrDelete(String baseUrl, String path, HttpMethod method,
                                                           Class<T> responseType) {
        URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(path)
                .build()
                .toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<T> requestEntity = new HttpEntity<T>(headers);
        return restTemplate.exchange(builder, method, requestEntity, responseType);
    }

    @Override
    public <T> ResponseEntity<T> getRemoteEntity (String baseUrl, String path, Class<T> responseClass) {
        URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(path)
                .build()
                .toUri();
        return restTemplate.getForEntity(builder, responseClass);
    }

}
