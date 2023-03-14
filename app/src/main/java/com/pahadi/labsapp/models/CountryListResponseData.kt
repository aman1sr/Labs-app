package com.pahadi.labsapp.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryListResponseData(
    @Json(name = "countries_id")
    val countriesId: String?,
    @Json(name = "countries_iso_code")
    val countriesIsoCode: String?,
    @Json(name = "countries_name")
    val countriesName: String?,
    @Json(name = "country_code")
    val countryCode: String?,
    @Json(name = "flag")
    val flag: String?
)