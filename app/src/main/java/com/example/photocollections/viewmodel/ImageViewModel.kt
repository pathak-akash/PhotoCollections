package com.example.photocollections.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photocollections.model.Images
import com.example.photocollections.repository.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ImageViewModel @Inject constructor(private val imageRepository: ImageRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            imageRepository.getImages()
        }
    }

    val images : LiveData<List<Images>>
        get() = imageRepository.images
}