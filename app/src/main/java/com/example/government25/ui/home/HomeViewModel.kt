package com.example.government25.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.government25.data.database.entity.PostEntity
import com.example.government25.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {
    private val _isRefreshing = MutableStateFlow(false)

    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    private val _postList = MutableStateFlow<List<PostEntity>>(emptyList())
    val postList = _postList.asStateFlow()


    init {
        getPosts()
    }

    fun onRefresh() {
        viewModelScope.launch {
            _isRefreshing.emit(true)
            getPosts()
            _isRefreshing.emit(false)
        }
    }

    private fun getPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            postRepository.getAllPost().distinctUntilChanged()
                .collect() {
                    if (it.isEmpty()) {
                        Log.e("Empty ", ": Empty List")
                    } else {
                        _postList.value = it
                        Log.e("Data", postList.value.toString())
                    }
                }
        }
    }
}