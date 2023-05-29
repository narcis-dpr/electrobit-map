package com.example.electrobitemap.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ElektrobitResponse(
    @SerializedName("address")
    @Expose
    val address: String?,
    @SerializedName("city")
    @Expose
    val city: String?,
    @SerializedName("country")
    @Expose
    val country: String?,
    @SerializedName("fax")
    @Expose
    val fax: String?,
    @SerializedName("image")
    @Expose
    val image: String?,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("tel")
    @Expose
    val tel: String?
)