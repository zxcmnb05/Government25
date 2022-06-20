package com.example.government25.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.government25.data.database.entity.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Query("SELECT * FROM post_data")
    fun getAll(): Flow<List<PostEntity>>

    @Query("SELECT * FROM post_data WHERE postIdx = :idx")
    suspend fun getPostByIdx(idx: Int): PostEntity

    @Delete
    suspend fun delete(post: PostEntity)

    @Insert
    suspend fun insert(post: PostEntity)
}