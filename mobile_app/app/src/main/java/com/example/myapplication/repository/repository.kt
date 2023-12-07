package com.example.myapplication.repository


import android.util.Log
import com.example.myapplication.models.UniversityModel
import com.example.myapplication.network.AppAPI
import com.example.myapplication.dataOrException.DataOrException
import javax.inject.Inject

class AppRepository @Inject constructor(private val api: AppAPI) {
    private val TAG = "AppRepository"

    suspend fun getUgandanUniversities(): DataOrException<UniversityModel, Exception> {
        val dataOrException = DataOrException<UniversityModel, Exception>()
        try {
            val result = api.getUgandanUniversities()
            if (result.isSuccessful) {
                dataOrException.data = result.body()
                Log.d(TAG, "getUgandanUniversities: ${result.body()}")
            }
        } catch (exception: Exception) {
            Log.e(TAG, "getUgandanUniversities: ${exception}", )
            dataOrException.e = exception
        }
        return dataOrException
    }
}