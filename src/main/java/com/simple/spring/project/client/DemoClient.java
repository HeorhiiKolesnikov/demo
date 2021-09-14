package com.simple.spring.project.client;

import java.net.http.HttpResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.simple.spring.project.models.DemoModel;

public class DemoClient extends BaseClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    @Override
    public String getBaseUrl() {
        return BASE_URL;
    }

    public HttpResponse<DemoModel> request() {
        return get(BASE_URL, new TypeReference<>() {});
    }
}
