package com.example.government25.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.government25.data.model.Post
import com.example.government25.ui.theme.SkyBlue
import com.example.government25.ui.theme.Typography


@Composable
fun PostCard(
    post: Post,
    selectPost: (Int) -> Unit = {}
) {
    Column(modifier = Modifier
        .clickable(onClick = { selectPost(post.id) })
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        PostTitle(post)
        PostVote(post)
    }
}

@Composable
fun PostTitle(post: Post) {
    Text(
        text = post.title,
        style = Typography.subtitle1
    )
}

@Composable
fun PostVote(post: Post) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "${post.voteNum}명", textAlign = TextAlign.End,
        style = MaterialTheme.typography.body2,
        color = SkyBlue
    )
}