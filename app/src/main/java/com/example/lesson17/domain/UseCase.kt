package com.example.lesson17.domain

import com.example.lesson17.data.NasaApi
import com.example.lesson17.helper_classes.PhotosResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UseCase {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/mars-photos/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(NasaApi::class.java)
    suspend fun executeAPI(): PhotosResponse{
        return api.getResponse()
    }
}