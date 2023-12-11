package com.example.myapplication.network

import com.example.myapplication.models.Result
import com.example.myapplication.models.Transactions
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface AppAPI{
    @GET("/transactions")
    suspend fun fetchAllTransactions():Response<Transactions>

    @GET("/transactions/filter")
    suspend fun fetchFilteredTransactions(
        @Query(ApiConstants.START_DATE) startDate: String?,
        @Query(ApiConstants.END_DATE) endDate: String?
    ):Response<List<Result>>
}