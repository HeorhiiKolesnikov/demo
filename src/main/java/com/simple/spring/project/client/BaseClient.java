package com.simple.spring.project.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.BodySubscriber;

import com.fasterxml.jackson.core.type.TypeReference;
import com.simple.spring.project.utils.JsonUtils;

public abstract class BaseClient {

    private final static HttpClient client;

    static {
        client = HttpClient.newHttpClient();
    }

    protected abstract String getBaseUrl();

    protected <T> HttpResponse<T> get(String url, TypeReference<T> c) {
        try {
            var request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            return client.send(request, getBodyHandler(c));
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <T> BodyHandler<T> getBodyHandler(TypeReference<T> targetType) {
        HttpResponse.BodySubscriber<InputStream> upstream = HttpResponse.BodySubscribers.ofInputStream();

        return responseInfo -> HttpResponse.BodySubscribers.mapping(upstream, (InputStream body) -> {
            try {
                return JsonUtils.readByteArray(body.readAllBytes(), targetType);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });
    }
}


