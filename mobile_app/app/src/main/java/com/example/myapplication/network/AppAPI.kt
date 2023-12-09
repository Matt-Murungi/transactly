package com.example.myapplication.network

import com.example.myapplication.models.TransactionHistory
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface AppAPI{
    @GET("/transactions")
    suspend fun fetchAllTransactions():Response<TransactionHistory>
}