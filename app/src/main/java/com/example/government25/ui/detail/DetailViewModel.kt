package com.example.government25.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.government25.data.database.entity.PostEntity
import com.example.government25.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val postRepository: PostRepository) :
    ViewModel() {
    private val _post = MutableStateFlow<PostEntity>(PostEntity(0, "", "", false))
    val post = _post.asStateFlow()

    fun getPost(idx: Int) {
        viewModelScope.launch {
            _post.value = postRepository.getPostByIdx(idx)
            Log.e("Post", _post.value.toString())
        }
    }
}