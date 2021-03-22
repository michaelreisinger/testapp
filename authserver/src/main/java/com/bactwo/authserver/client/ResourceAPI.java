package com.bactwo.authserver.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResourceAPI {

    <T> ResponseEntity<T> exchangeRemotePostOrPut(String baseUrl, String path, HttpMethod method, Object object,
                                                  Class<T> responseType);

    <T> ResponseEntity<T> exchangeRemoteGetOrDelete (String baseUrl, String url, HttpMethod method,
                                                     Class<T> responseType);

    <T> ResponseEntity<T> getRemoteEntity (String baseUrl, String path, Class<T> responseClass);

}
