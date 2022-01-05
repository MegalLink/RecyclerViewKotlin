package com.example.recyclerview.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.recyclerview.repository.EqRepository
import com.example.recyclerview.domain.Earthquake
import com.example.recyclerview.persistance.getDatabase
import kotlinx.coroutines.launch
// using by viewModel() this application si automatically passed to this view model
class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val db= getDatabase(application.applicationContext)
    private val eqRepository= EqRepository(db)
    val eqList=eqRepository.eqList
    init {
        viewModelScope.launch {
            eqRepository.fetchEqList()
        }
    }
}