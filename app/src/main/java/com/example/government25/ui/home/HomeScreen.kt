package com.example.government25.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.government25.R
import com.example.government25.ui.theme.Gray
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun HomeScreen(
    vm: HomeViewModel,
    selectPost: (Int) -> Unit,
    clickWrite: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                backgroundColor = MaterialTheme.colors.background
            )
        },
        content = { HomeContent(vm, selectPost, clickWrite, it) }
    )
}

@Composable
fun HomeContent(
    vm: HomeViewModel,
    selectPost: (Int) -> Unit,
    clickWrite: () -> Unit,
    contentPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
    ) {

        /*TabRow(
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
        }*/
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {
            PostList(
                vm = vm,
                selectPost = { selectPost(it) }

            )
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                WriteButton(
                    onClick = { clickWrite() }
                )
            }
        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun PostList(
    vm: HomeViewModel,
    selectPost: (Int) -> Unit
) {
    val isRefresh by vm.isRefreshing.collectAsState()
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = isRefresh),
        onRefresh = { vm.onRefresh() }) {

        LazyColumn() {
            item {
                Column {
                    vm.postList.value.forEach { post ->
                        PostCard(post, selectPost)
                        PostListDivider()
                    }
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