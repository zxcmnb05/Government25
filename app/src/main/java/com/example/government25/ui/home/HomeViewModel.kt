package com.example.government25.ui.home

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.government25.data.model.Post
import com.example.government25.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {
    var selectTab by mutableStateOf(0)

    var postData = mutableStateListOf<Post>()
        private set

    var recentData = mutableStateListOf<Post>()
        private set
    var popularData = mutableStateListOf<Post>()
        private set

    init {
        recentData.add(Post(1, "최신순1", "최신순 1번입니다", 11))
        recentData.add(Post(2, "최신순2", "최신순 2번입니다", 12))
        recentData.add(Post(3, "최신순3", "최신순 3번입니다", 13))

        popularData.add(Post(1, "인기순1", "인기순 1번입니다", 21))
        popularData.add(Post(2, "인기순2", "인기순 2번입니다", 22))
        popularData.add(Post(3, "인기순3", "인기순 3번입니다", 23))

        postData.addAll(recentData)
    }

    fun syncData() {
        when (selectTab) {
            0 -> {
                postData.clear()
                postData.addAll(recentData)
            }
            1 -> {
                postData.clear()
                postData.addAll(popularData)
            }
        }
    }
}