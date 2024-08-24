package com.example.photocollections.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.photocollections.model.Images

@Dao
interface ImageDao {

    @Query("SELECT * FROM images")
    fun getImageFromDb() : LiveData<List<Images>>

}