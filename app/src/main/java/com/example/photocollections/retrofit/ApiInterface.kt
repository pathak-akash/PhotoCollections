package com.example.photocollections.retrofit

import com.example.photocollections.model.Images
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/photos")
    fun getImagesData(): Call<List<Images>>

}