package com.example.mvvmexample.models.coronaNews

data class CoronaNews(
    val success: Boolean,
    val result: List<CoronaNewsResult>
)