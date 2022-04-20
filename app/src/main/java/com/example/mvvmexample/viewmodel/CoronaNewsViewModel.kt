package com.example.mvvmexample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.repository.AnalyticsAdapter
import com.example.mvvmexample.models.coronaNews.CoronaNewsResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoronaNewsViewModel @Inject constructor(private val analyticsAdapter: AnalyticsAdapter) :
    ViewModel() {

    private val _getCoronaNews = MutableLiveData<List<CoronaNewsResult>>()
    val getCoronaNews: LiveData<List<CoronaNewsResult>>
        get() = _getCoronaNews

    init {
        getCoronaNews()

    }


    private fun getCoronaNews() {
        try {
            viewModelScope.launch {
                analyticsAdapter.getCoronaNews().let {
                    if (it.isSuccessful) {
                        _getCoronaNews.value = it.body()!!.result
                    } else {
                        Log.e("Error", "Data cekilemedi")
                    }

                }
            }
        } catch (e: Exception) {
            Log.e("Hata", "${e.message}")
        }

    }
}

