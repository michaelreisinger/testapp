package com.bactwo.authserver.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface ResourceAPI {

    <T> ResponseEntity<T> exchangeRemotePostOrPut(String baseUrl, String path, HttpMethod method, T object,
                                                  Class<T> responseType);

    <T> ResponseEntity<T> exchangeRemoteGetOrDelete (String baseUrl, String url, HttpMethod method,
                                                     Class<T> responseType);

    <T> T postRemote(String baseUrl, String path,Object ipcRequestObject, Class<T> dtoClass);

    <T> ResponseEntity<T> postRemoteWithResponse (String baseUrl, String path,
                                                  Object ipcRequestObject, Class<T> responseClass);

    <T> T getRemote(String baseUrl, String path, Class<T> requestClass);

    <T> ResponseEntity<T> getRemoteEntity (String baseUrl, String path, Class<T> requestClass);

    <T> T getRemoteByObjectId(String baseUrl, String path, String objectId, Class<T> requestClass);

    void putRemote(String baseUrl, String path,String objectId, Object ipcRequestObject);

    <T> T  patchRemote(String baseUrl, String path, Object ipcRequestObject, String objectId,
                       Class<T> responseClass);

    void deleteRemote(String baseUrl, String path, String objectId);

}
