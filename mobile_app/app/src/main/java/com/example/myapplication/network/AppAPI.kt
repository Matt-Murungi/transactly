package com.example.myapplication.network

import com.example.myapplication.models.UniversityModel
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface AppAPI{
    @GET("search?country=Uganda")
    suspend fun getUgandanUniversities():Response<UniversityModel>
}