package com.pahadi.labsapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pahadi.labsapp.data.CountryRepo
import com.pahadi.labsapp.models.CountryListReponse
import kotlinx.coroutines.launch

class CountryListViewModel : ViewModel() {


    private val _countryList = MutableLiveData<CountryListReponse>()
    val countryList : LiveData<CountryListReponse> = _countryList

    init {
        getCountryList()
    }

    fun getCountryList() = viewModelScope.launch {
        CountryRepo.getCountryList()?.let {
                _countryList.postValue(it)
        }
        }
    }


