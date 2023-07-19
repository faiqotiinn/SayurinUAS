package com.example.sayursegar.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.sayursegar.model.Fresh
import com.example.sayursegar.repository.FreshRepository
import kotlinx.coroutines.launch

class FreshViewModel (private val repository: FreshRepository): ViewModel() {
    val allFresh: LiveData<List<Fresh>> = repository.allFresh.asLiveData()

    fun insert(fresh: Fresh) = viewModelScope.launch {
        repository.insertFresh(fresh)
    }

    fun delete(fresh: Fresh) = viewModelScope.launch {
        repository.deleteFresh(fresh)
    }

    fun update(fresh: Fresh) = viewModelScope.launch {
        repository.updateFresh(fresh)
    }
}

class FreshViewModelFactory(private val repository: FreshRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom((FreshViewModel::class.java))){
            return FreshViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}