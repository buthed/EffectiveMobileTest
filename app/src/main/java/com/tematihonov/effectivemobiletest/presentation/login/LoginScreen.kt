package com.tematihonov.effectivemobiletest.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.presentation.app_components.ButtonEnter
import com.tematihonov.effectivemobiletest.presentation.app_components.TopAppBar
import com.tematihonov.effectivemobiletest.presentation.login.components.EmTextField
import com.tematihonov.effectivemobiletest.presentation.login.components.EmTextFieldPhone
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun LoginScreen(buttonClick: () -> Unit) {
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
                    .padding(vertical = 20.dp),
                textAlign = TextAlign.Center,
                lineHeight = 5.sp,
                color = MaterialTheme.colors.textGrey
            )
        },
        containerColor = MaterialTheme.colors.bgWhite
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding() + 120.dp
                ), contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                // First name
                EmTextField(
                    value = viewModel.firstName,
                    placeholder = stringResource(id = R.string.entry_first_name),
                    onValueChange = { newText ->
                        viewModel.firstName = capitalizeWords(newText)
                        viewModel.firstNameValidation = checkButtonColor(newText, viewModel)
                    },
                    validation = viewModel.firstNameValidation,
                    clearField = {
                        viewModel.firstName = ""
                        viewModel.firstNameValidation =
                            checkButtonColor(viewModel.firstName, viewModel)
                    }
                )

                // Second name
                EmTextField(
                    value = viewModel.secondName,
                    placeholder = stringResource(id = R.string.entry_second_name),
                    onValueChange = { newText ->
                        viewModel.secondName = capitalizeWords(newText)
                        viewModel.secondNameValidation = checkButtonColor(newText, viewModel)
                    },
                    validation = viewModel.secondNameValidation,
                    clearField = {
                        viewModel.secondName = ""
                        viewModel.secondNameValidation =
                            checkButtonColor(viewModel.secondName, viewModel)
                    }
                )

                // Phone number
                EmTextFieldPhone(
                    value = viewModel.phoneNumber,
                    placeholder = stringResource(id = R.string.entry_phone_number),
                    onValueChange = { newText ->
                        if (viewModel.phoneNumber.length == 0 && newText == "7") {
                        } else {
                            if (newText.length <= 10) viewModel.phoneNumber = newText
                        }
                        viewModel.phoneNumberValidation =
                            checkButtonColor(viewModel.phoneNumber, viewModel, isNumber = true)
                    },
                    validation = viewModel.phoneNumberValidation,
                    clearField = {
                        viewModel.phoneNumber = ""
                        viewModel.phoneNumberValidation = checkButtonColor(
                            viewModel.phoneNumber,
                            viewModel,
                            isNumber = true
                        )
                    },
                )
                Spacer(modifier = Modifier.size(0.dp))



                ButtonEnter(
                    validateStatus = viewModel.buttonActivity,
                    buttonClick = buttonClick
                )
            }
        }
    }
}

private fun capitalizeWords(input: String): String {
    return input.split(" ").joinToString(" ") { it.capitalize() }
}

fun checkButtonColor(
    newText: String,
    viewModel: LoginViewModel,
    isNumber: Boolean = false,
): Boolean {
    with(viewModel) {
        if (isNumber) {
            if (newText.length == 10) phoneNumberValidation = checkPhoneNValidation(newText)
        }
        buttonActivity =
            if (firstName.isNotEmpty() && secondName.isNotEmpty() && phoneNumber.isNotEmpty() && firstNameValidation && secondNameValidation && phoneNumberValidation && phoneNumber.length == 10) {
                true
            } else false
    }
    if (isNumber) {
        checkPhoneNValidation(newText)
    }
    return checkValidation(newText)
}

private fun checkValidation(newText: String) = newText.chars()
    .mapToObj(Character.UnicodeBlock::of)
    .allMatch { char ->
        char.equals(Character.UnicodeBlock.CYRILLIC)
    }

private fun checkPhoneNValidation(phoneNumber: String): Boolean {
    val phoneRegex = Regex("^\\+7\\d{10}$")
    val last10Chars = if (phoneNumber.length >= 10) {
        phoneNumber.substring(phoneNumber.length - 10)
    } else {
        phoneNumber
    }
    return phoneRegex.matches("+7$last10Chars")
}

@Composable
@Preview
fun LoginScreenPreview() {
    //LoginScreen()
}