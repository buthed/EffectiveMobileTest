package com.tematihonov.effectivemobiletest.mapper

fun formatPhoneNumber(input: String): String {
    return "+7 ${input.substring(0, 3)} ${input.substring(3, 6)} ${
        input.substring(
            6,
            8
        )
    } ${input.substring(8, 10)}"
}