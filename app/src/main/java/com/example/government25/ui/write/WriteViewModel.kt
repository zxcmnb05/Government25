package com.example.government25.ui.write

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.government25.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor(postRepository: PostRepository) : ViewModel() {
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
}