package com.konrad.intership12026.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.konrad.intership12026.db.model.SampleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SampleDao {
    @Insert
    suspend fun insert(item: SampleEntity)

    @Query("SELECT * FROM SampleEntity")
    fun getAllAsFlow(): Flow<List<SampleEntity>>
}