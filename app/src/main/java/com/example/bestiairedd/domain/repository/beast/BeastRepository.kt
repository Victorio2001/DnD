package com.example.bestiairedd.domain.repository.beast

import com.example.bestiairedd.data.api.RetrofitClient
import com.example.bestiairedd.domain.model.beast.BeastShow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BeastRepository : IBeastRepository {

    //private val apiKey = "8b91a26b"
    private val dndApi = RetrofitClient.IDDApi_

    override suspend fun searchBeast(query: String): List<BeastShow> {
        return withContext(Dispatchers.IO) {
            try {

                Thread.sleep(2000)

                val response = dndApi.getMonsters()
                val list = response.results ?: emptyList()


                //! triche vérifie si contient val search
                val filtered = list.filter {
                    it.name.contains(query, ignoreCase = true)
                }

                filtered.map { x ->
                    BeastShow(
                        index = x.index,
                        name = x.name,
                        url = x.url
                    )
                }

            } catch (e: Exception) {
                emptyList()
            }
        }
    }
}