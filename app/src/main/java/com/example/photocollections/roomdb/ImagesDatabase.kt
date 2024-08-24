package com.example.photocollections.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.photocollections.model.Images

@Database(entities = [Images::class], version = 1, exportSchema = false)
abstract class ImagesDatabase : RoomDatabase()  {

    abstract fun imageDao() : ImageDao

    companion object {

        private var INSTANCE: ImagesDatabase? = null

        fun getDatabase(context: Context): ImagesDatabase {

            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    ImagesDatabase::class.java,
                    "images_database"
                )

                builder.build()
            }

            return INSTANCE!!
        }
    }
}