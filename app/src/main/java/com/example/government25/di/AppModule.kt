package com.example.government25.di

import android.content.Context
import androidx.room.Room
import com.example.government25.data.database.PostDatabase
import com.example.government25.data.database.dao.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePostDao(postDatabase: PostDatabase): PostDao = postDatabase.postDao()

    @Singleton
    @Provides
    fun appProvideDatabase(@ApplicationContext context: Context): PostDatabase
        = Room.databaseBuilder(
            context,
            PostDatabase::class.java,
            "post_data"
        ).fallbackToDestructiveMigration()
        .build()
}