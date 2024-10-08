package com.example.pokemon.network

import com.example.pokemon.model.PokemonDetailsModel
import com.example.pokemon.model.PokemonListModel
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface APIService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<PokemonListModel>

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(
        @Path("name") name: String
    ): Response<PokemonDetailsModel>
}

    fun getRetrofitClient(): APIService {
        // Create or client
        val client = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/") // Specify your base URL
            .addConverterFactory(GsonConverterFactory.create()) // Specify JSon convertion method
            .client(OkHttpClient())// Add converter factory for Gson
            .build()
        return client.create(APIService::class.java)
    }
