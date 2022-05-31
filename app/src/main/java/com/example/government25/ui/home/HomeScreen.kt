package com.example.government25.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.government25.R
import com.example.government25.data.model.Post
import com.example.government25.ui.theme.Gray
import com.example.government25.ui.theme.SkyBlue

@Composable
fun HomeScreen(
    vm: HomeViewModel,
    selectPost: (Int) -> Unit,
    selectWrite: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                backgroundColor = MaterialTheme.colors.background
            )
        },
        content = { HomeContent(vm, selectPost, selectWrite) }
    )
}

@Composable
fun HomeContent(vm: HomeViewModel, selectPost: (Int) -> Unit, selectWrite: () -> Unit) {
    val tabs = listOf(stringResource(id = R.string.recent), stringResource(id = R.string.popular))
    Column(modifier = Modifier.fillMaxSize()) {

        TabRow(
            selectedTabIndex = vm.selectTab,
            backgroundColor = MaterialTheme.colors.background,
            contentColor = SkyBlue
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(selected = vm.selectTab == index, onClick = {
                    vm.selectTab = index
                    vm.syncData()
                }) {
                    Text(text = tab, modifier = Modifier.padding(16.dp))
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            PostList(
                posts = vm.postData,
                selectPost = { selectPost(it) }
            )
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                WriteButton(
                    onClick = { selectWrite() }
                )
            }
        }
    }
}

@Composable
fun PostList(
    posts: List<Post>,
    selectPost: (Int) -> Unit
) {
    LazyColumn() {
        item {
            Column {
                posts.forEach { post ->
                    PostCard(post, selectPost)
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
        color = Gray
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