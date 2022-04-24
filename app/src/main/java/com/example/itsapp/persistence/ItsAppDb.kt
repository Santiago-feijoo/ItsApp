package com.example.itsapp.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.itsapp.persistence.daos.InfectionsDao
import com.example.itsapp.persistence.entities.Infections

@Database(
    entities = [Infections::class],
    version = 1
)
abstract class ItsAppDb: RoomDatabase() {
    /** DAOS **/
    abstract fun infectionsDao(): InfectionsDao

}