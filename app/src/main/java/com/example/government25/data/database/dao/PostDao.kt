package com.example.government25.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.government25.data.database.entity.PostEntity

@Dao
interface PostDao {

    @Query("SELECT * FROM post_data")
    fun getAll(): LiveData<List<PostEntity>>

    @Query("SELECT * FROM post_data WHERE postIdx = :idx")
    fun getPostByIdx(idx: Int): PostEntity

    @Delete
    suspend fun delete(post: PostEntity)

    @Insert
    suspend fun insert(post: PostEntity)
}