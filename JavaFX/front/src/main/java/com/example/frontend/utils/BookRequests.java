package com.example.frontend.utils;
import com.example.frontend.schemas.Booking;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.List;

public class BookRequests {
    public static List<Booking> executeGet() throws UnirestException {
        HttpResponse<JsonNode> apiResponse = Unirest.get("http://localhost:8080/booking").asJson();
        return new Gson().fromJson(apiResponse.getBody().toString(), new TypeToken<List<Booking>>(){}.getType());
    }
}
