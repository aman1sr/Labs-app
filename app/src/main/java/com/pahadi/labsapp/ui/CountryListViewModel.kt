package com.pahadi.labsapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pahadi.labsapp.data.CountryRepo
import kotlinx.coroutines.launch

class CountryListViewModel : ViewModel() {
    val TAG = "CountryList_d"
    init {
        getCountryList()
    }

    fun getCountryList() = viewModelScope.launch {
        CountryRepo.getCountryList()?.let {
            Log.d(TAG, "getCountryList: "+it)
        }
    }


}