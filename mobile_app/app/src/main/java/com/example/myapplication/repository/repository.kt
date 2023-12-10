package com.example.myapplication.repository


import android.util.Log
import com.example.myapplication.network.AppAPI
import com.example.myapplication.dataOrException.DataOrException
import com.example.myapplication.models.Result
import com.example.myapplication.models.Transactions
import javax.inject.Inject

class AppRepository @Inject constructor(private val api: AppAPI) {
    private val TAG = "AppRepository"

    suspend fun fetchAllTransactions(): DataOrException<Transactions, Exception> {
        val dataOrException = DataOrException<Transactions, Exception>()
        try {
            val result = api.fetchAllTransactions()
            Log.d(TAG, "${result.body()}: ")
            if (result.isSuccessful) {
                dataOrException.data = result.body()
                dataOrException.hasData = true
            }
        } catch (exception: Exception) {
            dataOrException.e = exception
            dataOrException.hasData = false

        }
        return dataOrException
    }

    suspend fun fetchFilteredTransactions(startDate: String?, endDate: String?): DataOrException<List<Result>, Exception>{
        val dataOrException = DataOrException<List<Result>,Exception>()
        try{
            val result = api.fetchFilteredTransactions(startDate, endDate)
            Log.d(TAG, "Success ${result.body()}")
            if(result.isSuccessful){
                dataOrException.data = result.body()
                dataOrException.hasData = true
            }

        }catch (exception: Exception) {
            Log.d(TAG, "Error ${exception}: ")

            dataOrException.e = exception
            dataOrException.hasData = false
        }
        return dataOrException
    }

}