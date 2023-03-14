package com.pahadi.labsapp.models


import com.google.gson.annotations.SerializedName

data class CountryListReponseData(
    @SerializedName("countries_id")
    val countriesId: String?,
    @SerializedName("countries_iso_code")
    val countriesIsoCode: String?,
    @SerializedName("countries_name")
    val countriesName: String?,
    @SerializedName("country_code")
    val countryCode: String?,
    @SerializedName("flag")
    val flag: String?
)