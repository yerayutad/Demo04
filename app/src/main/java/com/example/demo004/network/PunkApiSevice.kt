package com.example.demo004.network

import com.example.demo004.model.Beer
import retrofit2.Call
import retrofit2.http.GET

interface PunkApiSevice {
    @GET("beers")
    fun getAllBeers(): Call<List<Beer>>
}