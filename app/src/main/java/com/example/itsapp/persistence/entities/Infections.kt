package com.example.itsapp.persistence.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Infections(
    @PrimaryKey(autoGenerate = true)
    val idInfection: Int,
    val nameInfection: String
)
