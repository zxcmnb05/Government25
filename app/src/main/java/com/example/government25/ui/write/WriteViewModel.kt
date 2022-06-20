package com.example.government25.ui.write

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.government25.data.database.entity.PostEntity
import com.example.government25.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {
    private val _title: MutableState<String> = mutableStateOf("")
    val title: State<String> get() = _title

    private val _content: MutableState<String> = mutableStateOf("")
    val content: State<String> get() = _content


    fun onTitleChange(title: String) {
        _title.value = title
    }

    fun onContentChange(content: String) {
        _content.value = content
    }

    fun onWriteBtn() = viewModelScope.launch {
        postRepository.addTodo(
            post = PostEntity(
                postTitle = title.value,
                postContent = content.value,
            )
        )
    }
}