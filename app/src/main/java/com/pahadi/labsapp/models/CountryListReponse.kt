package com.pahadi.labsapp.models


import com.google.gson.annotations.SerializedName

data class CountryListReponse(
    @SerializedName("data")
    val `data`: List<CountryListReponseData?>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Int?
)