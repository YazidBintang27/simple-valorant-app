package com.latihan.valorantapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.latihan.valorantapp.models.AgentModel
import com.latihan.valorantapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
    private val _agentData = MutableStateFlow(emptyList<AgentModel.Data?>())

    val agentData: StateFlow<List<AgentModel.Data?>>
        get() = _agentData

    init {
        getAllAgents()
        Log.d("ViewModel", "${agentData.value.size}")
    }

    private fun getAllAgents() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                val data = repository.requestAllAgents()
                Log.d("ViewModel", "Data log")
                _agentData.value = data
            }
        }
    }
}