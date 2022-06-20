package com.example.government25.data.repository

import com.example.government25.data.database.dao.PostDao
import com.example.government25.data.database.entity.PostEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject constructor(private val postDao: PostDao) {

    fun getAllPost(): Flow<List<PostEntity>> = postDao.getAll().flowOn(Dispatchers.IO).conflate()

    suspend fun getPostByIdx(idx: Int) = postDao.getPostByIdx(idx)


    suspend fun addTodo(post: PostEntity) = postDao.insert(post)


    suspend fun deletePost(post: PostEntity) = postDao.delete(post)

}