package com.example.one2cook.domain.model

import com.example.one2cook.presentation.model.HitsUI
import com.example.one2cook.presentation.model.RecipeUI
import com.example.one2cook.presentation.model.RecipesUI


fun Recipes.toUI() = RecipesUI(
    recipes = recipes?.map { it.toUI() }
)

fun Hits.toUI() = HitsUI(
    recipeUI = recipe?.toUI()
)

fun Recipe.toUI() = RecipeUI(
    titleRecipe = titleRecipe,
    image = image,
    sourceRecipe = sourceRecipe,
    urlSource = urlSource,
    calories = calories,
    cuisineType = cuisineType,
    ingredients = ingredients,
    totalTime = totalTime
)