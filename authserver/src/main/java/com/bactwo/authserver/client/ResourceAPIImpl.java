package com.bactwo.authserver.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class ResourceAPIImpl implements ResourceAPI {
    
    private final RestTemplate restTemplate;

    @Autowired
    public ResourceAPIImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> ResponseEntity<T> exchangeRemotePostOrPut(String baseUrl, String path, HttpMethod method, T object,
                                                         Class<T> responseType) {
        URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(path)
                .build()
                .toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<T> requestEntity = new HttpEntity<T>(object, headers);
        return restTemplate.exchange(builder, method, requestEntity, responseType);
    }

    @Override
    public <T> T getRemote(String baseUrl, String path, Class<T> requestClass) {
        URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(path)
                .build()
                .toUri();
        return restTemplate.getForObject(builder, requestClass);
    }

    @Override
    public <T> ResponseEntity<T> postRemoteWithResponse (String baseUrl, String path,
                                                         Object ipcRequestObject, Class<T> responseClass) {
        URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(path)
                .build()
                .toUri();
        return restTemplate.postForEntity(builder, ipcRequestObject, responseClass);
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
    public <T> T postRemote(String baseUrl, String path, Object ipcRequestObject, Class<T> responseClass) {
        URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(path)
                .build()
                .toUri();
        return restTemplate.postForObject(builder, ipcRequestObject, responseClass);
    }

    @Override
    public <T> ResponseEntity<T> getRemoteEntity (String baseUrl, String path, Class<T> responseClass) {
        URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(path)
                .build()
                .toUri();
        return restTemplate.getForEntity(builder, responseClass);
    }

    @Override
    public <T> T getRemoteByObjectId(String baseUrl, String path, String objectId, Class<T> requestClass) {
        URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(path)
                .build()
                .toUri();
        String builderResult = builder + objectId;
        return (T) restTemplate.getForObject(builder, requestClass);
    }

    @Override
    public void putRemote(String baseUrl, String path, String objectId, Object ipcRequestObject) {
        URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(path)
                .build()
                .toUri();
        String builderResult = builder + objectId;
        restTemplate.put(builderResult, ipcRequestObject);
    }

    @Override
    public <T> T  patchRemote(String baseUrl, String path, Object ipcRequestObject, String objectId,
                              Class<T> responseClass) {
        URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(path)
                .build()
                .toUri();
        String builderResult = builder + objectId;
        return restTemplate.patchForObject(builderResult, ipcRequestObject, responseClass);
    }

    @Override
    public void deleteRemote(String baseUrl, String path, String objectId) {
        URI builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path(path)
                .build()
                .toUri();
        String builderResult = builder + objectId;
        restTemplate.delete(builderResult);
    }

}
