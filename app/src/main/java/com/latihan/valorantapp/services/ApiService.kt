package com.latihan.valorantapp.services

import com.latihan.valorantapp.models.AgentModel
import com.latihan.valorantapp.utils.ApiConstant
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(ApiConstant.AGENTS)
    suspend fun getAllAgents(): Response<AgentModel>
}