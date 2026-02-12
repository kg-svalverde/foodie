package com.konrad.intership12026.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SampleEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String
)