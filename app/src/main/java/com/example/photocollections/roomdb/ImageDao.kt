package com.example.photocollections.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.photocollections.model.Images

@Dao
interface ImageDao {

    @Insert
    fun addImages(images: List<Images>)

    @Query("SELECT * FROM images")
    fun getImageFromDb() : LiveData<List<Images>>

}