package com.example.electrobitemap.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.electrobitemap.data.local.entity.ElectrobitLocationsEntity

@Database(
    entities = [ElectrobitLocationsEntity::class],
    version = 1
)
abstract class ElectrobitLocationsDatabase: RoomDatabase() {
    abstract val locationData: GetDataDao
}