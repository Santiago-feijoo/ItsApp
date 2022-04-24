package com.example.itsapp.menu

import android.util.Log
import com.example.itsapp.persistence.daos.InfectionsDao
import com.example.itsapp.persistence.entities.Infections
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MenuRepository @Inject constructor() {
    /** ATRIBUTOS **/
    @Inject lateinit var infections: InfectionsDao
    private lateinit var response: MenuResponse

    /** METODOS **/
    fun setInterface(response: MenuResponse) {
        this.response = response

    }

    suspend fun setInfections(infectionsList: Array<String>) {
        withContext(Dispatchers.IO) {
            Log.i("Repository", "Registrando infecciones...")
            infections.deleteAll()

            infectionsList.forEach { nameInfection ->
                val infectionNew = Infections(0, nameInfection)
                infections.insert(infectionNew)

            }

            response.infectionsInserted("¡Infecciones registradas!")

        }

    }

    suspend fun getAllInfections() {
        withContext(Dispatchers.IO) {
            Log.i("Repository", "Consultando infecciones...")
            val data = infections.getAll() as ArrayList<Infections>
            response.loadInfections(data)

        }

    }

    suspend fun getInfectionsByName(filter: String) {
        withContext(Dispatchers.IO) {
            Log.i("Repository", "Consultando infecciones por $filter...")
            val data = infections.getInfectionByName(filter) as ArrayList<Infections>
            response.loadInfections(data)

        }

    }

}