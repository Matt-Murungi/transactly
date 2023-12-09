package com.example.myapplication.repository


import android.util.Log
import com.example.myapplication.network.AppAPI
import com.example.myapplication.dataOrException.DataOrException
import com.example.myapplication.models.TransactionHistory
import javax.inject.Inject

class AppRepository @Inject constructor(private val api: AppAPI) {
    private val TAG = "AppRepository"

    suspend fun fetchAllTransactions(): DataOrException<TransactionHistory, Exception> {
        val dataOrException = DataOrException<TransactionHistory, Exception>()
        try {
            val result = api.fetchAllTransactions()
            if (result.isSuccessful) {
                dataOrException.data = result.body()
            }
        } catch (exception: Exception) {
            dataOrException.e = exception
        }
        return dataOrException
    }
}