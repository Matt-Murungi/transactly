package com.example.myapplication.ui.utils


import java.text.NumberFormat
import java.util.Locale

fun formatThousandSeparator(number: Int): String {
    val formatter = NumberFormat.getInstance(Locale.US)
    formatter.maximumFractionDigits = 0
    formatter.isGroupingUsed = true
    return formatter.format(number)
}

