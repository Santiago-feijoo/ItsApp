package com.example.itsapp.menu

import com.example.itsapp.persistence.entities.Infections

interface MenuResponse {
    fun infectionsInserted(message: String)
    fun loadInfections(infections: ArrayList<Infections>)

}