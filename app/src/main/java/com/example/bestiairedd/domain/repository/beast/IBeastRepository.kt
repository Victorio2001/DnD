package com.example.bestiairedd.domain.repository.beast

import com.example.bestiairedd.domain.model.beast.BeastShow
import com.example.bestiairedd.domain.model.beast.BeastShowMore

interface IBeastRepository {

    suspend fun searchBeast(query: String): List<BeastShow>

    suspend fun getBeastDetailById(index: String): BeastShowMore?

}