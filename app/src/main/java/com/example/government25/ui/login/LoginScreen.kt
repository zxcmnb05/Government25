package com.example.government25.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.government25.R
import com.example.government25.ui.theme.SkyBlue

@Composable
fun LoginScreen(vm: LoginViewModel, clickLogin: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Id(vm = vm)
        Spacer(modifier = Modifier.height(8.dp))
        Pw(vm = vm)
        Spacer(modifier = Modifier.height(16.dp))
        Login(vm = vm, clickLogin)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Id(vm: LoginViewModel) {

    TextField(
        value = vm.id.value,
        onValueChange = {
            vm.onIdChange(it)
        },
        label = { Text(stringResource(R.string.login_id)) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background,
            focusedIndicatorColor = SkyBlue,
            focusedLabelColor = SkyBlue,
            cursorColor = SkyBlue
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        singleLine = true
    )
}

@Composable
fun Pw(vm: LoginViewModel) {
    TextField(
        value = vm.pw.value,
        onValueChange = {
            vm.onPwChange(it)
        },
        label = { Text(stringResource(R.string.login_pw)) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background,
            focusedIndicatorColor = SkyBlue,
            focusedLabelColor = SkyBlue,
            cursorColor = SkyBlue
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        singleLine = true
    )
}

@Composable
fun Login(vm: LoginViewModel, clickLogin: () -> Unit) {
    Button(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(55.dp),
        onClick = { clickLogin() },
        colors = ButtonDefaults.buttonColors(SkyBlue)
    ) {
        Text(text = stringResource(R.string.login), color = Color.White)
    }
}