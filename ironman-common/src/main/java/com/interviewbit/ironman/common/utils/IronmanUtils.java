package com.interviewbit.ironman.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

public class IronmanUtils {

    public static Gson getGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
    public static String passwordHashFunction(String password){
        Long hashedPassword = Long.valueOf(password.hashCode() * 13 * password.hashCode());
        return String.valueOf(hashedPassword * password.hashCode() * 25);
    }

    public static UriComponentsBuilder getUrl(String baseUrl) {
        return UriComponentsBuilder.fromHttpUrl(baseUrl);
    }

    public static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

}
