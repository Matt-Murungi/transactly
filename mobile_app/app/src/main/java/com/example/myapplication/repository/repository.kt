package com.example.myapplication.repository


import android.net.Uri
import android.util.Log
import com.example.myapplication.network.AppAPI
import com.example.myapplication.dataOrException.DataOrException
import com.example.myapplication.models.Result
import com.example.myapplication.models.Transactions
import org.json.JSONObject
import javax.inject.Inject

class AppRepository @Inject constructor(private val api: AppAPI) {
    private val TAG = "AppRepository"

    suspend fun fetchAllTransactions(): DataOrException<Transactions, Exception> {
        val dataOrException = DataOrException<Transactions, Exception>()
        try {
            val result = api.fetchAllTransactions(null, null)
            Log.d(TAG, "fetchAllTransactions: ${result.body()}")

            if (result.isSuccessful) {

                dataOrException.data = result.body()
                dataOrException.hasData = true
            }else{

                dataOrException.hasData = false
                dataOrException.data = result.body()
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
            Log.d(TAG, "fetchFilteredTransactions ${result.body()}")

            if(result.isSuccessful){
                dataOrException.data = result.body()
                dataOrException.hasData = true
            }else{
                val errorMessage = result.errorBody()!!.charStream().readText()
                dataOrException.hasData = false
                dataOrException.message = errorMessage
            }

        }catch (exception: Exception) {

            dataOrException.e = exception
            dataOrException.hasData = false
        }
        return dataOrException
    }


    suspend fun fetchPaginatedTransaction(url: String): DataOrException<Transactions, Exception>{
        val dataOrException = DataOrException<Transactions,Exception>()
        var uri = Uri.parse(url)
        val limit = uri.getQueryParameter("limit")
        val offset = uri.getQueryParameter("offset")
        try{
            val result = api.fetchAllTransactions(limit, offset)
            if(result.isSuccessful){
                Log.d(TAG, "Success ${result.body()}")
                dataOrException.data = result.body()
                dataOrException.hasData = true
            }else{
                val errorMessage = result.errorBody()!!.charStream().readText()
                dataOrException.hasData = false
                dataOrException.message = errorMessage
            }

        }catch (exception: Exception) {

            dataOrException.e = exception
            dataOrException.hasData = false
        }
        return dataOrException
    }

}