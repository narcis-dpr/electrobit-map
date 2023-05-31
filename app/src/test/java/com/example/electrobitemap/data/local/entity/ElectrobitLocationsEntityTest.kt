package com.example.electrobitemap.data.local.entity

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ElectrobitLocationsEntityTest {

    @Mock
    lateinit var entity: ElectrobitLocationsEntity

    @Test
    fun testEntityFields() {
        val address = "123 Main St"
        val city = "City"
        val country = "Country"
        val fax = "123-456-7890"
        val name = "Electrobit"
        val tel = "987-654-3210"
        val image = "image_url"
        val id = 1

        entity = ElectrobitLocationsEntity(
            address = address,
            city = city,
            country = country,
            fax = fax,
            name = name,
            tel = tel,
            image = image,
            id = id
        )

        assertEquals(address, entity.address)
        assertEquals(city, entity.city)
        assertEquals(country, entity.country)
        assertEquals(fax, entity.fax)
        assertEquals(name, entity.name)
        assertEquals(tel, entity.tel)
        assertEquals(image, entity.image)
        assertEquals(id, entity.id)
    }
}