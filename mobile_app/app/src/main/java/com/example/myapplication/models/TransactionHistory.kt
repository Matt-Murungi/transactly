package com.example.myapplication.models

data class TransactionHistory(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Result>
)
data class Result(
    val amount: Int,
    val category: String,
    val id: Int,
    val service: String,
    val txfinish: String,
    val type: String
)