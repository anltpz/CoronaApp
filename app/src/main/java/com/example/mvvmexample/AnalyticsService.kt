package com.example.mvvmexample

import com.example.mvvmexample.models.coronaNews.CoronaNews
import com.example.mvvmexample.models.totalData.Corona
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface AnalyticsService {

    @Headers(
        "authorization: apikey 4jKSt2aS3CibwWIEBOHIx7:2VmXKkijjhcSrifZ1JxUzf",
        "content-type: application/json"
    )
    @GET("totalData")
    suspend fun getAll(): Response<Corona>;


    @Headers(
        "authorization: apikey 4jKSt2aS3CibwWIEBOHIx7:2VmXKkijjhcSrifZ1JxUzf",
        "content-type: application/json"
    )
    @GET("coronaNews")
    suspend fun getCoronaNews(): Response<CoronaNews>;



}