package com.latihan.valorantapp.repository

import com.latihan.valorantapp.models.AgentModel

interface Repository {
    suspend fun requestAllAgents(): List<AgentModel.Data?>
}