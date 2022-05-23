package com.example.government25.ui.write

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.relocationRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.government25.ui.theme.SkyBlue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WriteScreen(vm: WriteViewModel) {
    val scrollState = rememberScrollState()
    val request = remember { BringIntoViewRequester() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
            .bringIntoViewRequester(request),
        horizontalAlignment = Alignment.End
    ) {
        Title(vm)
        Spacer(modifier = Modifier.height(16.dp))
        Content()
        Spacer(modifier = Modifier.height(16.dp))
        SubmitButton()
    }
}

@Composable
fun Title(vm: WriteViewModel) {
    var titleInput by remember { (mutableStateOf("")) }

    TextField(
        placeholder = { (Text(text = "청원 제목을 입력하여 주세요.")) },
        value = titleInput,
        onValueChange = { titleInput = it },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = Color.Gray,
            cursorColor = Color.Gray
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go),
        modifier = Modifier
            .border(1.dp, Color.Black)
            .fillMaxWidth()
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Content() {
    var contentInput by remember { (mutableStateOf("")) }
    val coroutineScope = rememberCoroutineScope()

    TextField(
        placeholder = { (Text(text = "청원할 내용을 입력하여 주세요.")) },
        value = contentInput,
        onValueChange = { contentInput = it },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = Color.Gray,
            cursorColor = Color.Gray
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go),
        modifier = Modifier
            .border(1.dp, Color.Gray)
            .fillMaxWidth()
            .height(500.dp)
    )
}

@Composable
fun SubmitButton() {

    OutlinedButton(
        onClick = { },
        border = BorderStroke(1.dp, color = SkyBlue),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = SkyBlue
        ),
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .padding(16.dp)
    ) {
        Text(text = "작성하기")
    }
}