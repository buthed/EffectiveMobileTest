package com.tematihonov.effectivemobiletest.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.presentation.LoginViewModel
import com.tematihonov.effectivemobiletest.presentation.app_components.ButtonEnter
import com.tematihonov.effectivemobiletest.presentation.app_components.TopAppBar
import com.tematihonov.effectivemobiletest.presentation.login.components.EmTextField
import com.tematihonov.effectivemobiletest.presentation.login.components.EmTextFieldPhone
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun LoginScreen() {
    val viewModel = hiltViewModel<LoginViewModel>()
    Scaffold(
        topBar = {
            TopAppBar(stringResource(id = R.string.entry_title))
        },
        bottomBar = {
            Text(
                text = stringResource(id = R.string.entry_warning), style = Typography.labelMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 11.dp),
                textAlign = TextAlign.Center,
                lineHeight = 5.sp
            )
        },
        containerColor = MaterialTheme.colors.bgWhite
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues = it), contentAlignment = Alignment.Center
        ) {//TODO add padding to top
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                var firstName by remember { mutableStateOf("") }
                var firstNameValidation by remember { mutableStateOf(true) }
                EmTextField(
                    value = firstName,
                    placeholder = stringResource(id = R.string.entry_first_name),
                    onValueChange = { newText ->
                        firstName = newText
                        firstNameValidation = checkValidation(newText)
                    },
                    firstNameValidation
                )

                var secondName by remember { mutableStateOf("") }
                var secondNameValidation by remember { mutableStateOf(true) }
                EmTextField(
                    value = secondName,
                    placeholder = stringResource(id = R.string.entry_second_name),
                    onValueChange = { newText ->
                        secondName = newText
                        secondNameValidation = checkValidation(newText)
                    },
                    validation = secondNameValidation,
                )

                var phoneNumber by remember { mutableStateOf("") }
                var phoneNumberValidation by remember { mutableStateOf(true) }
                EmTextFieldPhone(
                    value = phoneNumber,
                    placeholder = stringResource(id = R.string.entry_phone_number),
                    onValueChange = { newText ->
                        if (newText.length <= 10) phoneNumber = newText
                        secondNameValidation = checkValidation(newText)
                    },
                    validation = phoneNumberValidation,
                )

                ButtonEnter(true) {
                    viewModel.userLogined = true
                } //TODO add
            }
        }
    }
}

private fun checkValidation(newText: String) = newText.chars()
    .mapToObj(Character.UnicodeBlock::of)
    .allMatch { char ->
        char.equals(Character.UnicodeBlock.CYRILLIC)
    }

@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen()
}