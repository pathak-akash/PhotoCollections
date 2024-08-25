package com.example.photocollections.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.photocollections.repository.ImageRepository

class ImageViewModelFactory(private val repository: ImageRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ImageViewModel(repository) as T
    }

}