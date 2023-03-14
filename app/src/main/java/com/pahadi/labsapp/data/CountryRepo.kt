package com.pahadi.labsapp.data

import com.pahadi.labsapp.network.NetworkClient

object CountryRepo {
    val api = NetworkClient.publicApi
    suspend fun getCountryList() = api.countryList().body()?.data
}