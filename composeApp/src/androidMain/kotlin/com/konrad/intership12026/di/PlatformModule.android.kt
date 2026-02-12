package com.konrad.intership12026.di

import android.content.Context
import androidx.room.RoomDatabase
import com.konrad.intership12026.db.AppDatabase
import com.konrad.intership12026.db.getDatabaseBuilder
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
actual class PlatformModule {
    @Single
    fun providesDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
        return getDatabaseBuilder(context)
    }
}