package com.example.government25.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post_data")
data class PostEntity(

    @PrimaryKey(autoGenerate = true)
    var postIdx: Int = 0,

    @ColumnInfo(name = "post_title")
    val postTitle: String,

    @ColumnInfo(name = "post_content")
    val postContent: String,

    @ColumnInfo(name = "post_like")
    val postLike: Boolean = false
)
