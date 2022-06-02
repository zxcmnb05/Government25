package com.example.government25.ui.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _id: MutableState<String> = mutableStateOf("")
    val id: State<String> get() = _id

    private val _pw: MutableState<String> = mutableStateOf("")
    val pw: State<String> get() = _pw

    fun login() {
        if (id.value.isNullOrBlank() || pw.value.isNullOrBlank()) {
            // Todo Error message
        } else {
            // Todo 서버통신
        }
    }

    fun onIdChange(id: String) {
        _id.value = id
    }

    fun onPwChange(pw: String) {
        _pw.value = pw
    }
}