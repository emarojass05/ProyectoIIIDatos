package com.example.login.interfaces;

import com.example.login.models.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginAPI {
    @GET("login")
    public Call<Login> login(@Body Login login);
}
