package com.example.photocollections.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.photocollections.Utils.NetworkUtils
import com.example.photocollections.model.Images
import com.example.photocollections.retrofit.ApiService
import com.example.photocollections.roomdb.ImagesDatabase

class ImageRepository(private val imagesDatabase: ImagesDatabase,
                      private val apiService: ApiService,
                      private val application: Context) {


    private val imageLiveData = MutableLiveData<List<Images>>()

    val images: LiveData<List<Images>>
        get() = imageLiveData

    suspend fun getImages(){

        if (NetworkUtils.isInternetAvailable(application)) {
            //Online
            val result = apiService.getImagesData()
            if (result.body() != null) {
                imagesDatabase.imageDao().addImages(result.body()!!)
                imageLiveData.postValue(result.body())
            }
        } else {
            //Offline
            val images = imagesDatabase.imageDao().getImageFromDb()
            imageLiveData.postValue(images.value)

        }

    }
}