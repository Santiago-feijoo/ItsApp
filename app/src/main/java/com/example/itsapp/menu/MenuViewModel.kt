package com.example.itsapp.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itsapp.persistence.entities.Infections
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(private val repository: MenuRepository): ViewModel(), MenuResponse {
    init {
        repository.setInterface(this)

    }

    /** ATRIBUTOS **/
    val infectionsInserted: LiveData<String> get() = _infectionsInserted
    private val _infectionsInserted = MutableLiveData<String>()

    val loadInfections: LiveData<ArrayList<Infections>> get() = _loadInfections
    private val _loadInfections = MutableLiveData<ArrayList<Infections>>()

    /** METODOS **/
    fun setInfections(infectionsList: Array<String>) {
        viewModelScope.launch(viewModelScope.coroutineContext + Dispatchers.IO) {
            repository.setInfections(infectionsList)

        }

    }

    fun getInfections(filter: String = "") {
        viewModelScope.launch(viewModelScope.coroutineContext + Dispatchers.IO) {
            if(filter.isEmpty()) {
                repository.getAllInfections()

            } else {
                repository.getInfectionsByName(filter)

            }

        }

    }

    override fun infectionsInserted(message: String) {
        _infectionsInserted.postValue(message)
    }

    override fun loadInfections(infections: ArrayList<Infections>) {
        _loadInfections.postValue(infections)
    }

}