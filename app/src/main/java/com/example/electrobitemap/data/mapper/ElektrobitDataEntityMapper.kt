package com.example.electrobitemap.data.mapper

import com.example.electrobitemap.data.local.entity.ElectrobitLocationsEntity
import com.example.electrobitemap.data.model.Elektrobit
import com.example.electrobitemap.data.model.ElektrobitResponse

fun ElectrobitLocationsEntity.mapToElektrobit(): Elektrobit {
    return Elektrobit(
        address = address!!,
        city = city!!,
        country = country!!,
        fax = fax!!,
        name = name!!,
        tel = tel!!,
        image = image
    )
}

fun Elektrobit.mamToEntity(): ElectrobitLocationsEntity {
    return ElectrobitLocationsEntity(
        address = address,
        city = city,
        country = country,
        fax = fax,
        name = name,
        tel = tel,
        image = image
    )
}

fun ElektrobitResponse.mapToElektrobit(): Elektrobit {
    return Elektrobit(
        address = address!!,
        city = city!!,
        country = country!!,
        fax = fax!!,
        name = name!!,
        tel = tel!!,
        image = image
    )
}

fun Elektrobit.mapToElektrobitResponse(): ElektrobitResponse {
    return ElektrobitResponse(
        address = address,
        city = city,
        country = country,
        fax = fax,
        name = name,
        tel = tel,
        image = image
    )
}