package com.example.government25.ui.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.government25.ui.theme.NotoSansKr

@Composable
fun DetailScreen(
    vm: DetailViewModel
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        DetailTitle(title = "기숙사 4층 너무 시끄러워요")
        DetailContent(content = "요즘 기숙사 4층 너무 시끄러워요. 자치위원분들 4층 단속 철저하게 해주셨으면 합니다.")
        LikeButton()
    }
}

@Composable
fun DetailTitle(
    title: String
) {
    Text(
        text = title,
        style = TextStyle(
            fontFamily = NotoSansKr,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        ),
    )
}

@Composable
fun DetailContent(
    content: String
) {
    Text(
        text = content,
        style = TextStyle(
            fontFamily = NotoSansKr,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
}

@Composable
fun LikeButton() {
    val btn = remember { mutableStateOf(false) }
    val btnColor = if (btn.value) Color(0xFF0066FF) else Color.Gray

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            onClick = { btn.value = !btn.value },
            border = BorderStroke(1.dp, color = btnColor),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color(0xFF0066FF)
            ),
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .padding(8.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ThumbUp,
                contentDescription = "",
                tint = btnColor
            )
        }
    }
}