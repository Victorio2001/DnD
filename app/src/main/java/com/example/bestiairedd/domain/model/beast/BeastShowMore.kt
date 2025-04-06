package com.example.bestiairedd.domain.model.beast

data class BeastShowMore (

    val index: String,
    val name: String,
    val size: String,
    val type: String,
    val alignment: String,

    val armor_class: List<ArmorClass>,

    val hit_points: Int,
    val hit_dice: String?,
    val speed: Speed,

    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,

    val languages: String?,
    val challenge_rating: Int,
    val xp: Int?,

    //!  Image
    val image: String?,
    val url: String?
)



