package com.tematihonov.effectivemobiletest.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color


data class Colors(
    val bgWhite: Color = Color(0xFFFFFFFF),
    val bgLightGray: Color = Color(0xFFF8F8F8),
    val bgPink: Color = Color(0xFFD62F89),
    val bgLightPink: Color = Color(0xFFFF8AC9),

    val textPink: Color = Color(0xFFD62F89),
    val textLightPink: Color = Color(0xFFFF8AC9),
    val textOrange: Color = Color(0xFFF9A249),
    val textWhite: Color = Color(0xFFFFFFFF),
    val textGrey: Color = Color(0xFFA0A1A3),
    val textDarkGrey: Color = Color(0xFF3E3E3E),
    val textBlack: Color = Color(0xFF000000),

    val elementPink: Color = Color(0xFFD62F89),
    val elementOrange: Color = Color(0xFFF9A249),
    val elementWhite: Color = Color(0xFFFFFFFF),
    val elementLightGray: Color = Color(0xFFDEDEDE),
    val elementDarkBlue: Color = Color(0xFF52606D),
    val elementDarkGray: Color = Color(0xFF333333),
    val elementBlack: Color = Color(0xFF000000),
)

val LocalColors = compositionLocalOf { Colors() }

val MaterialTheme.colors: Colors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current