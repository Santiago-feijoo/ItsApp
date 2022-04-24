package com.example.itsapp.persistence.daos

import androidx.room.*
import com.example.itsapp.persistence.entities.Infections

@Dao
interface InfectionsDao {
    /** QUERYS **/
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(infections: Infections)

    @Query("DELETE FROM Infections")
    fun deleteAll()

    @Query("SELECT * FROM Infections")
    fun getAll(): List<Infections>

    @Query("SELECT * FROM Infections WHERE nameInfection LIKE :filter || '%'")
    fun getInfectionByName(filter: String): List<Infections>

}