package com.example.mvvmexample.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.mvvmexample.AnalyticsAdapter
import com.example.mvvmexample.models.coronaNews.CoronaNewsResult
import com.example.mvvmexample.models.totalData.Corona
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val analyticsAdapter: AnalyticsAdapter) : ViewModel() {

    private val getAllData = MutableLiveData<Corona>()
    val _getAllData: LiveData<Corona>
        get() = getAllData


    private val _totalCases = MutableLiveData<String>("Nulll")
    val totalCases: LiveData<String>
        get() = _totalCases

    private val getAllLiveData = MutableLiveData<Corona>()
    val _getAllLiveData = Transformations.map(getAllLiveData) {
        return@map "Total cases ${it.result.totalCases}\n Total Dead ${it.result.totalDeaths}\n  Recovered ${it.result.totalRecovered}"

    }


    init {

        totalCasesData()
    }

    fun totalCasesData() {
        try {
            viewModelScope.launch {
                analyticsAdapter.getAll().let {
                    if (it.isSuccessful) {
                        _totalCases.value = it.body()?.result?.totalCases
                        getAllLiveData.value = it.body()
                    } else {
                        Log.d("hata", "${it.message()}")
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("hata", "${e.message}")
        }

    }



}