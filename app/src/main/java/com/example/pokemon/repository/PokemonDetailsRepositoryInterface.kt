package com.example.pokemon.repository

import com.example.pokemon.model.PokemonDetailsModel
import com.example.pokemon.network.APIService
import com.example.pokemon.network.getRetrofitClient
import retrofit2.Response

interface PokemonDetailsRepositoryInterface {
    suspend fun getPokemonDetails(name: String): Response<PokemonDetailsModel>
}
class PokemonDetailsRepository(
    private val apiService: APIService = getRetrofitClient()
): PokemonDetailsRepositoryInterface {
    override suspend fun getPokemonDetails(name: String): Response<PokemonDetailsModel> {
        return apiService.getPokemonDetails(name)
    }
}