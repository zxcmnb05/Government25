package com.example.government25.ui.home

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.government25.data.model.Post
import com.example.government25.ui.theme.NotoSansKr

@Composable
fun PostCard(
    post: Post,
    isClicked: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .clickable { isClicked() }
    ) {
        PostTitle(post)
        PostVote(post)
    }
}

@Composable
fun PostTitle(post: Post) {
    Text(
        text = post.title,
        fontSize = 16.sp,
        fontFamily = NotoSansKr,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun PostVote(post: Post) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "${post.voteNum}명", textAlign = TextAlign.End,
        style = MaterialTheme.typography.body2,
        color = Color(0xFF5599FF)
    )
}