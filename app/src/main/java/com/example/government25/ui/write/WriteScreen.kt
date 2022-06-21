package com.example.government25.ui.write

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.government25.R
import com.example.government25.ui.theme.SkyBlue

@ExperimentalFoundationApi
@Composable
fun WriteScreen(vm: WriteViewModel, clickWrite: () -> Unit) {
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
        Content(vm)
        Spacer(modifier = Modifier.height(16.dp))
        SubmitButton(vm, clickWrite)
    }
}

@Composable
fun Title(vm: WriteViewModel) {
    TextField(
        label = { (Text(text = stringResource(id = R.string.write_title))) },
        value = vm.title.value,
        onValueChange = { vm.onTitleChange(it) },
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
            .height(60.dp)
    )
}


@Composable
fun Content(vm: WriteViewModel) {
    TextField(
        placeholder = { (Text(text = stringResource(id = R.string.write_content))) },
        value = vm.content.value,
        onValueChange = { vm.onContentChange(it) },
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
fun SubmitButton(vm: WriteViewModel, clickWrite: () -> Unit) {
    val context = LocalContext.current

    OutlinedButton(
        onClick = {
            if (vm.title.value.isNotBlank() || vm.content.value.isNotBlank()) {
                vm.onWriteBtn()
                clickWrite()
            } else {
                Toast.makeText(context, "제목, 내용을 적어주세요", Toast.LENGTH_SHORT).show()
            }
        },
        border = BorderStroke(1.dp, color = SkyBlue),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = SkyBlue
        ),
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .padding(vertical = 16.dp),
        contentPadding = PaddingValues(vertical = 4.dp, horizontal = 16.dp)
    ) {
        Text(text = "작성하기")
    }
}