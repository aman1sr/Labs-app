package com.pahadi.labsapp.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryListResponse(
    @Json(name = "data")
    val `data`: List<CountryListResponseData?>,
    @Json(name = "message")
    val message: String?,
    @Json(name = "status")
    val status: Int?
)