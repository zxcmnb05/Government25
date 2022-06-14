package com.example.government25.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.government25.data.database.dao.PostDao
import com.example.government25.data.database.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
abstract class PostDatabase: RoomDatabase() {
    abstract fun postDao(): PostDao
}