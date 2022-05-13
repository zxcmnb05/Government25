package com.example.government25.ui.write

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WriteScreen() {
    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp)
    ) {
        Title(title = "제목")
    }
}

@Composable
fun Title(
    title: String
) {
    Text(text = title, style = MaterialTheme.typography.h5)
}