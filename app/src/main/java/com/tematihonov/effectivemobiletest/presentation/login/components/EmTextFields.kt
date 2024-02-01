package com.tematihonov.effectivemobiletest.presentation.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tematihonov.effectivemobiletest.R
import com.tematihonov.effectivemobiletest.ui.colors
import com.tematihonov.effectivemobiletest.ui.theme.Typography

@Composable
fun EmTextField(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    validation: Boolean,
) {
//    when (validation) {
//        true -> MaterialTheme.colors.bgLightGray
//        false -> MaterialTheme.colors.bgLightPink
//    } //TODO add
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            //containerColor = MaterialTheme.colors.bgLightGray
        )
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.bgLightGray),
            colors = TextFieldDefaults.colors(
                disabledContainerColor = MaterialTheme.colors.bgLightGray,
                errorContainerColor = MaterialTheme.colors.bgLightGray,
                focusedContainerColor = MaterialTheme.colors.bgLightGray,
                unfocusedContainerColor = MaterialTheme.colors.bgLightGray,
                focusedTextColor = MaterialTheme.colors.textBlack,
//                disabledPlaceholderColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            textStyle = Typography.displayMedium,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            placeholder = {
                Text(
                    text = placeholder,
                    style = Typography.displayMedium,
                    color = MaterialTheme.colors.textGrey
                )
            },
            trailingIcon = {
                if (value.isNotEmpty()) Icon(
                    painter = painterResource(id = R.drawable.icon_small_close),
                    contentDescription = "",
                    modifier = Modifier.size(28.dp)
                )
            },
            singleLine = true,
        )
    }
}

@Composable
fun EmTextFieldPhone(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    validation: Boolean,
) {
//    when (validation) {
//        true -> MaterialTheme.colors.bgLightGray
//        false -> MaterialTheme.colors.bgLightPink
//    } //TODO add
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            //containerColor = MaterialTheme.colors.bgLightGray
        )
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.bgLightGray),
            colors = TextFieldDefaults.colors(
                disabledContainerColor = MaterialTheme.colors.bgLightGray,
                errorContainerColor = MaterialTheme.colors.bgLightGray,
                focusedContainerColor = MaterialTheme.colors.bgLightGray,
                unfocusedContainerColor = MaterialTheme.colors.bgLightGray,
                focusedTextColor = MaterialTheme.colors.textBlack,
//                disabledPlaceholderColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            textStyle = Typography.displayMedium,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            ),
            visualTransformation = PhoneVisualTransformation("+7 000 000 00 00",'0'), //TODO fix mask
            placeholder = {
                Text(
                    text = placeholder,
                    style = Typography.displayMedium,
                    color = MaterialTheme.colors.textGrey
                )
            },
            trailingIcon = {
                if (value.isNotEmpty()) Icon(
                    painter = painterResource(id = R.drawable.icon_small_close),
                    contentDescription = "",
                    modifier = Modifier.size(28.dp)
                )
            },
            singleLine = true,
        )
    }
}

class PhoneVisualTransformation(val mask: String, val maskNumber: Char) : VisualTransformation {

    private val maxLength = mask.count { it == maskNumber }

    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.length > maxLength) text.take(maxLength) else text

        val annotatedString = buildAnnotatedString {
            if (trimmed.isEmpty()) return@buildAnnotatedString

            var maskIndex = 0
            var textIndex = 0
            while (textIndex < trimmed.length && maskIndex < mask.length) {
                if (mask[maskIndex] != maskNumber) {
                    val nextDigitIndex = mask.indexOf(maskNumber, maskIndex)
                    append(mask.substring(maskIndex, nextDigitIndex))
                    maskIndex = nextDigitIndex
                }
                append(trimmed[textIndex++])
                maskIndex++
            }
        }

        return TransformedText(annotatedString, PhoneOffsetMapper(mask, maskNumber))
    }

    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (other !is PhonedVisualTransformation) return false
//        if (mask != other.mask) return false
//        if (maskNumber != other.maskNumber) return false
        return true
    }

    override fun hashCode(): Int {
        return mask.hashCode()
    }
}

private class PhoneOffsetMapper(val mask: String, val numberChar: Char) : OffsetMapping {

    override fun originalToTransformed(offset: Int): Int {
        var noneDigitCount = 0
        var i = 0
        while (i < offset + noneDigitCount) {
            if (mask[i++] != numberChar) noneDigitCount++
        }
        return offset + noneDigitCount
    }

    override fun transformedToOriginal(offset: Int): Int =
        offset - mask.take(offset).count { it != numberChar }
}

@Preview
@Composable
fun EmTextFieldPreview() {
    EmTextField(
        stringResource(id = R.string.entry_first_name),
        stringResource(id = R.string.entry_first_name),
        { },
        false
    )
}

@Preview
@Composable
fun EmTextFieldPhonePreview() {
    EmTextFieldPhone(
        stringResource(id = R.string.entry_phone_number),
        stringResource(id = R.string.entry_phone_number),
        { },
        false,
    )
}