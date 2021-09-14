package com.simple.spring.project.utils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import org.springframework.boot.json.JacksonJsonParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtils {

    public static <T> T readByteArray(byte[] array, TypeReference<T> c) {
        var mapper = new ObjectMapper();

        try {
            return mapper.readValue(array, c);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static <T> T readByteArray(byte[] array, Class<T> c) {
        var mapper = new ObjectMapper();

        try {
            return mapper.readValue(array, c);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
