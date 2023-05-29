package com.example.electrobitemap.data.model

data class Elektrobit(

    val address: String,
    val city: String,
    val country: String,
    val fax: String,
    val name: String,
    val tel: String,
    val image: String ?= ""
)