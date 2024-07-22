package com.latihan.valorantapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.latihan.valorantapp.models.AgentModel
import com.latihan.valorantapp.repository.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: RepositoryImpl
): ViewModel() {
    private val _agentByIndex = MutableStateFlow<AgentModel.Data?>(null)

    val agentByIndex: StateFlow<AgentModel.Data?>
        get() = _agentByIndex

    fun getAgentByIndex(index: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                val data = repository.requestAllAgents()[index]
                _agentByIndex.value = data
            }
        }
    }
}