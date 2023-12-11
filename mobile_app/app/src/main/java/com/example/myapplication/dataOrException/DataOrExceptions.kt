package com.example.myapplication.dataOrException


class DataOrException<T, E : Exception>(
    var data: T? = null,
    var hasData: kotlin.Boolean = false,
    var e: E? = null
)