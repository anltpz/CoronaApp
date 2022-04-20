package com.example.mvvmexample


import javax.inject.Inject

class AnalyticsAdapter @Inject constructor(
    private val service: AnalyticsService
) {

    suspend fun getAll() = service.getAll()
    suspend fun getCoronaNews() = service.getCoronaNews()

}