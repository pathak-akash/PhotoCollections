package com.example.photocollections.retrofit

import com.example.photocollections.model.Images
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/photos")
    fun getImagesData() : Response<List<Images>>

}