package com.myweatherapp.ui.helper

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PasswordVisualTransformation() = PasswordVisualTransformationSpec()

@Immutable
class PasswordVisualTransformationSpec : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            text = buildAnnotatedString {
                repeat(text.length) {
                    append("•")
                }
            },
            offsetMapping = OffsetMapping.Identity
        )
    }
}