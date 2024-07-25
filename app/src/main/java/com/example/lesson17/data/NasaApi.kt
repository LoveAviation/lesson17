package com.example.lesson17.data

import com.example.lesson17.helper_classes.PhotosResponse
import retrofit2.http.GET

interface NasaApi {
    @GET("api/v1/rovers/curiosity/photos?sol=1000&api_key=wMbbha8bSfLpOxqAjCelVdcPBq3p6KENrpaTiy9H")
    suspend fun getResponse(): PhotosResponse
}