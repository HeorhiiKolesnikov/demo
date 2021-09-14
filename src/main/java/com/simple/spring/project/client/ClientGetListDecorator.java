package com.simple.spring.project.client;

import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClientGetListDecorator<T> extends BaseClient {

    private final BaseClient client;

    @Override
    public String getBaseUrl() {
        return client.getBaseUrl();
    }

    public HttpResponse<List<T>> requestAsList() {
        return get(getBaseUrl(), new TypeReference<>() {});
    }
}
