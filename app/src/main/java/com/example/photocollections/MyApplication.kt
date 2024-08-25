package com.example.photocollections

import android.app.Application
import com.example.photocollections.repository.ImageRepository
import com.example.photocollections.retrofit.ApiService
import com.example.photocollections.retrofit.RetrofitInstance
import com.example.photocollections.roomdb.ImagesDatabase
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {

    private lateinit var imageRepository: ImageRepository

    override fun onCreate() {
        super.onCreate()

        val imageService = RetrofitInstance.getInstance().create(ApiService::class.java)
        val imagesDatabase = ImagesDatabase.getDatabase(applicationContext)
        imageRepository = ImageRepository(imagesDatabase, imageService, applicationContext)
    }
}