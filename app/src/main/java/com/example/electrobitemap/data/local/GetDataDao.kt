package com.example.electrobitemap.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.electrobitemap.data.local.entity.ElectrobitLocationsEntity

@Dao
interface GetDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertElectrobitLocation(spot: ElectrobitLocationsEntity)

    @Delete
    suspend fun deleteElectrobitLocation(spot: ElectrobitLocationsEntity)

    @Query("SELECT * FROM electrobitAroundTheWorld WHERE country = :country")
    fun getElectrobitLocationByCountry(country: String): List<ElectrobitLocationsEntity>


}