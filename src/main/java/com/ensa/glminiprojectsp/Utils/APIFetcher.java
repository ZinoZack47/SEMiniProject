package com.ensa.glminiprojectsp.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class APIFetcher {
    private static final String address = "http://localhost";
    private static final String port = "8081";

    private APIFetcher() {}
    public static <T> T getObject(String api, Class<T> clazz) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String url = address+":"+port+api;
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(request);

            HttpEntity entity = response.getEntity();
            InputStream inputStream = entity.getContent();

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(inputStream, clazz);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
