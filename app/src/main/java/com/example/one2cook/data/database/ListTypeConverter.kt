package com.example.one2cook.data.database

class ListTypeConverter {
    @androidx.room.TypeConverter
    fun fromIngredients(ingredients: List<String>): String {
        return ingredients.joinToString(",")
    }

    @androidx.room.TypeConverter
    fun toIngredients(data: String): List<String> {
        return data.split(",")
    }
}