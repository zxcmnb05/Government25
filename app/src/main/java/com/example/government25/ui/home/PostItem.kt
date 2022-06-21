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
import com.example.government25.data.database.entity.PostEntity
import com.example.government25.ui.theme.SkyBlue
import com.example.government25.ui.theme.Typography


@Composable
fun PostCard(
    post: PostEntity,
    selectPost: (Int) -> Unit = {}
) {
    Column(modifier = Modifier
        .clickable(onClick = { selectPost(post.postIdx) })
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        PostTitle(post)
//        PostVote(post)
    }
}

@Composable
fun PostTitle(post: PostEntity) {
    Text(
        text = post.postTitle,
        style = Typography.subtitle1
    )
}
/*

@Composable
fun PostVote(post: PostEntity) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "${post.postLike}명", textAlign = TextAlign.End,
        style = MaterialTheme.typography.body2,
        color = SkyBlue
    )
}*/
