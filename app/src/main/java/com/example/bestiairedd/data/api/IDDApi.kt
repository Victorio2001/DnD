package com.example.bestiairedd.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IDDApi {

//    @GET("/")
//    suspend fun searchBeastsApi(
//        @Query("apikey") apiKey: String,
//        @Query("s") search: String
//    ): DndSearchResponse


//    @GET("/")
//    suspend fun getBeastById(
//        @Query("apikey") apiKey: String,
//        @Query("i") imdbId: String
//    ): OmdbDetailResponse


    //!  Récupère la liste de monstres
    @GET("/api/2014/monsters")
    suspend fun getMonsters(): DndSearchResponse


    //! path insert la variable dans l'url
    @GET("/api/2014/monsters/{index}")
    suspend fun getMonsterByIndex(
        @Path("index") index: String
    ): DndDetailResponse

}