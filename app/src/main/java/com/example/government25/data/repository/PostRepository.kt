package com.example.government25.data.repository

import androidx.lifecycle.LiveData
import com.example.government25.data.database.dao.PostDao
import com.example.government25.data.database.entity.PostEntity
import javax.inject.Inject

class PostRepository @Inject constructor(private val postDao: PostDao) {

    val getAllPost: LiveData<List<PostEntity>> = postDao.getAll()

    suspend fun getPostByIdx(idx: Int) {
        postDao.getPostByIdx(idx)
    }

    suspend fun addTodo(post: PostEntity) {
        postDao.insert(post)
    }

    suspend fun deletePost(post: PostEntity) {
        postDao.delete(post)
    }
}