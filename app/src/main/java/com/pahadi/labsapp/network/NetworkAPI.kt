package com.pahadi.labsapp.network

import com.pahadi.labsapp.models.CountryListResponse
import retrofit2.Response
import retrofit2.http.GET

interface NetworkAPI {
    @GET("mylocalbusiness/getCountries")
    suspend fun countryList(): Response<CountryListResponse>

}