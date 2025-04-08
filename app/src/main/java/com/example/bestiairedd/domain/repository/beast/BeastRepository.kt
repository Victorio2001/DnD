package com.example.bestiairedd.domain.repository.beast

import com.example.bestiairedd.data.api.RetrofitClient
import com.example.bestiairedd.domain.model.beast.BeastShow
import com.example.bestiairedd.domain.model.beast.BeastShowMore
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



    override suspend fun getBeastDetailById(index: String): BeastShowMore? {
        return withContext(Dispatchers.IO) {
            try {
                val detailResponse = dndApi.getMonsterByIndex(index)
                //if (detailResponse.response == "True") {


                    // Conversion OmdbDetailResponse -> MovieDetail
                    BeastShowMore(
                        index = detailResponse.index ?: "",
                        name = detailResponse.name ?: "",
                        image = detailResponse.image ?: "",
                        size = detailResponse.size ?: "",
                        alignment = detailResponse.alignment ?: "",
                        strength = detailResponse.strength ?: 0,
                        dexterity = detailResponse.dexterity ?: 0,
                        constitution = detailResponse.constitution ?: 0,
                        intelligence = detailResponse.intelligence ?: 0,
                        wisdom = detailResponse.wisdom ?: 0,
                        charisma = detailResponse.charisma ?: 0,
                        languages = detailResponse.languages ?: "",
                        xp = detailResponse.xp ?: 0,
                        url = detailResponse.url ?: "",
                        type = detailResponse.type ?: ""

                    )
//                } else {
//                    null
//                }
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}