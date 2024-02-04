package com.tematihonov.effectivemobiletest.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.tematihonov.effectivemobiletest.R

val Typography = Typography(
    // Large title 1
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontSize = 20.sp,
        lineHeight = 26.sp,
    ),
    // Title 1
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontSize = 16.sp,
        lineHeight = 20.8.sp,
    ),
    // Title 2
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontSize = 14.sp,
        lineHeight = 18.2.sp,
    ),
    // Title 3
    headlineSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontSize = 12.sp,
        lineHeight = 15.6.sp,
    ),
    // Title 4
    headlineMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 14.sp,
        lineHeight = 18.2.sp,
    ),
    // Text 1
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 12.sp,
        lineHeight = 15.6.sp,
    ),
    // Caption 1
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 10.sp,
        lineHeight = 11.sp,
    ),
    // Button text 1
    displaySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontSize = 12.sp,
        lineHeight = 15.6.sp,
    ),
    // Button text 2
    displayLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontSize = 14.sp,
        lineHeight = 18.2.sp,
    ),
    // Element text
    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 9.sp,
        lineHeight = 10.sp,
    ),
    // Price text
    headlineLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_medium)),
        fontSize = 24.sp,
        lineHeight = 31.2.sp,
    ),
    // Placeholder text
    displayMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 16.sp,
    ),
    // Link text
    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.sf_pro_display_regular)),
        fontSize = 10.sp,
        lineHeight = 11.sp,
    )
)