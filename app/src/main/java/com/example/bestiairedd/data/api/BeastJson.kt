package com.example.bestiairedd.data.api

import com.google.gson.annotations.SerializedName

data class DndSearchResponse(
    @SerializedName("count") val count: Int?,
    @SerializedName("results") val results: List<DndMonsterShort>?
)


data class DndMonsterShort(
    @SerializedName("index") val index: String,
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)


data class DndDetailResponse(
    @SerializedName("index") val index: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("size") val size: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("alignment") val alignment: String?,

    @SerializedName("armor_class") val armorClass: List<DndArmorClass>?,
    @SerializedName("hit_points") val hitPoints: Int?,
    @SerializedName("hit_dice") val hitDice: String?,
    @SerializedName("speed") val speed: DndSpeed?,

    @SerializedName("strength") val strength: Int?,
    @SerializedName("dexterity") val dexterity: Int?,
    @SerializedName("constitution") val constitution: Int?,
    @SerializedName("intelligence") val intelligence: Int?,
    @SerializedName("wisdom") val wisdom: Int?,
    @SerializedName("charisma") val charisma: Int?,

    @SerializedName("languages") val languages: String?,
    @SerializedName("challenge_rating") val challengeRating: Int?,
    @SerializedName("xp") val xp: Int?,

    @SerializedName("image") val image: String?,
    @SerializedName("url") val url: String?
)


data class DndArmorClass(
    @SerializedName("type") val type: String?,
    @SerializedName("value") val value: Int?
)


data class DndSpeed(
    @SerializedName("walk") val walk: String?,
    @SerializedName("swim") val swim: String?
)

