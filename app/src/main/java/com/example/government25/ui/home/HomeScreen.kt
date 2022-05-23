package com.example.government25.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.government25.data.model.Post
import com.example.government25.ui.Screen
import com.example.government25.ui.theme.NotoSansKr

@Composable
fun HomeScreen(navController: NavController, vm: HomeViewModel) {

    Column(modifier = Modifier.fillMaxSize()) {
        Surface() {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.background,
                contentPadding = PaddingValues(16.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Text(
                    text = "정부25",
                    fontFamily = NotoSansKr,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background)
        ) {
            PostList(
                posts = listOf(dummyPosts1, dummyPosts2, dummyPosts3),
                isClicked = { navController.navigate(Screen.Detail.route) }
            )
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                WriteButton(
                    onClick = { navController.navigate(Screen.Write.route) }
                )
            }
        }
    }
}

@Composable
fun PostList(
    posts: List<Post>,
    isClicked: () -> Unit
) {
    LazyColumn() {
        item {
            Column {
                posts.forEach { post ->
                    PostCard(post, isClicked)
                    PostListDivider()
                }
            }
        }
    }
}

@Composable
private fun PostListDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 14.dp),
        color = Color.LightGray
    )
}

@Composable
fun WriteButton(
    onClick: () -> Unit,
) {
    IconButton(
        onClick = { onClick() }, modifier = Modifier
            .padding(16.dp)
            .border(1.dp, Color.Black, shape = CircleShape)
    ) {
        Icon(imageVector = Icons.Filled.Edit, contentDescription = null)
    }
}

val dummyPosts1 = Post(
    id = 1,
    title = "안녕하십니까 이번 대통령 출마한 홍준혁입니다.",
    content = "잘부탁드립니다.",
    voteNum = 103
)
val dummyPosts2 = Post(
    id = 2,
    title = "안녕하십니까 이번 대통령 출마한 손민재입니다.",
    content = "잘부탁드립니다.",
    voteNum = 103
)
val dummyPosts3 = Post(
    id = 3,
    title = "안녕하십니까 이번 대통령 출마한 신중빈입니다.",
    content = "잘부탁드립니다.",
    voteNum = 103
)