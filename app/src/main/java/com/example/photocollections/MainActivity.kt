package com.example.photocollections

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.photocollections.repository.ImageRepository
import com.example.photocollections.viewmodel.ImageViewModel
import com.example.photocollections.viewmodel.ImageViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var imageRepository: ImageRepository

    @Inject
    lateinit var imageViewModel: ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewModel =  ViewModelProvider(this, ImageViewModelFactory(repository = imageRepository)).get(ImageViewModel::class.java)

        imageViewModel.images.observe(this, Observer {
            //Get Data If Internet available from api service or while offline from database
        })
    }
}