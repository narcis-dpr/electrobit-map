package com.example.electrobitemap.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "electrobitAroundTheWorld")
data class ElectrobitLocationsEntity (
    @ColumnInfo(name = "address")
    val address: String?,
    @ColumnInfo(name = "city")
    val city: String?,
    @ColumnInfo(name = "country")
    val country: String?,
    @ColumnInfo(name = "fax")
    val fax: String?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "tel")
    val tel: String?,
    @ColumnInfo(name = "image")
    val image: String ?= "",
    @PrimaryKey(autoGenerate = true) val id: Int = 0
        )