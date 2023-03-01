package com.example.one2cook.presentation.model

import com.example.one2cook.domain.model.Recipe

fun RecipeUI.toDomain() = Recipe(
    titleRecipe = titleRecipe,
    sourceRecipe = sourceRecipe,
    image = image,
    urlSource = urlSource,
    calories = calories,
    ingredients = ingredients,
    totalTime = totalTime,
    yield = yield
)