package com.example.electrobitemap.di

import android.content.Context
import androidx.room.Room
import com.example.electrobitemap.data.local.ElectrobitLocationsDatabase
import com.example.electrobitemap.data.local.GetDataDao
import com.example.electrobitemap.data.local.MIGRATIONS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideElektrobitDatabase(@ApplicationContext context: Context) : ElectrobitLocationsDatabase {
        return Room.databaseBuilder(
            context,
            ElectrobitLocationsDatabase::class.java,
            "openWeather.db"
        ).addMigrations(*MIGRATIONS).build()
    }

    @Provides
    @Singleton
    fun provideWeatherTable(electrobitLocationsDatabase: ElectrobitLocationsDatabase) : GetDataDao {
        return electrobitLocationsDatabase.locationData

    }
}