package com.example.alexr.ideamanager.services;


import retrofit2.Call;
import retrofit2.http.GET;

public interface MessageService {
    @GET("message")
    Call<String> getMessages();
}
