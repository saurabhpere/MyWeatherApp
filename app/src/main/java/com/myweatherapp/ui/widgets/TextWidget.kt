package com.myweatherapp.ui.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Composable
fun CommonTextWithSpan(text: String?, boldText: String, color: Color) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = color)) {
            append(boldText)
        }
        append(" ")
        append(text ?: "")
    }

    Text(
        text = annotatedString,
        color = color,
        fontSize = TextUnit(20f, TextUnitType.Sp)
    )
}

@Composable
fun HistoryItem(label: String, value: String?) {
    Row(
        modifier = Modifier
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Label Text
        Text(
            text = label,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.width(60.dp) // Adjust width as needed
        )
        // Value Text
        Text(
            text = value?:"",
            style = MaterialTheme.typography.body1,
            color = Color.Black,
            fontSize = TextUnit(20f, TextUnitType.Sp)
        )
    }
}