package com.latihan.valorantapp.repository

import android.util.Log
import com.latihan.valorantapp.models.AgentModel
import com.latihan.valorantapp.services.ApiService
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
): Repository {
    override suspend fun requestAllAgents(): List<AgentModel.Data?> {
        val response = apiService.getAllAgents()
        if (response.isSuccessful) {
            response.body()?.data?.let {
                Log.d("RepoImpl", "Data: $it")
                return it
            }
        } else {
            Log.d("RepoImpl", "Error fetch data")
        }
        return emptyList()
    }
}