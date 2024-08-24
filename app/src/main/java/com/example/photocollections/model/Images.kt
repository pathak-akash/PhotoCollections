package com.example.photocollections.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "images")
data class Images(

    @SerializedName("albumId")
    @ColumnInfo("albumId")
    var albumId: Int? = null,

    @SerializedName("id")
    @PrimaryKey
    var id: Int? = null,

    @SerializedName("title")
    @ColumnInfo("title")
    var title: String? = null,

    @SerializedName("url")
    @ColumnInfo("url")
    var url: String? = null,

    @SerializedName("thumbnailUrl")
    @ColumnInfo("thumbnailUrl")
    var thumbnailUrl: String? = null

)