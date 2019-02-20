package com.example.galax.simplemovieapp.services.rest;

import com.example.galax.simplemovieapp.services.rest.dto.SearchResultDTO;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RestAPI {

    @GET("movie?sort_by=popularity.desc&api_key=a49cf8a5f42225880f049917a2262e81")
    Observable<SearchResultDTO> search(@Query("language") String lang);
}
