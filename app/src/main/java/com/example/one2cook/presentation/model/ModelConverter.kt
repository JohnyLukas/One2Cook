package com.example.one2cook.presentation.model

import com.example.one2cook.data.model.entity.FavoritesRecipeEntity
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

fun FavoritesRecipeUI.toRecipeUI() = RecipeUI(
    titleRecipe = titleRecipe,
    image = image,
    sourceRecipe = sourceRecipe,
    urlSource = urlSource,
    calories = calories,
    ingredients = ingredients,
    totalTime = totalTime,
    yield = yield
)

fun FavoritesRecipeUI.toEntity() = FavoritesRecipeEntity(
    id = id,
    isFavorites = isFavorites,
    titleRecipe = titleRecipe,
    image = image,
    sourceRecipe = sourceRecipe,
    urlSource = urlSource,
    calories = calories,
    ingredients = ingredients,
    totalTime = totalTime,
    yield = yield
)