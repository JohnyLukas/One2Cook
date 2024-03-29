package com.example.one2cook.domain.model

import com.example.one2cook.data.model.entity.FavoritesRecipeEntity
import com.example.one2cook.presentation.model.*


fun Recipes.toUI() = RecipesUI(
        recipes = recipes?.map { it.toUI() },
        nextPageLink = nextPageLink?.toUI()
    )

    fun Link.toUI() = LinkUI(
        nextPage = nextPage?.toUI()
    )

    fun Next.toUI() = NextUI(
        nextPageUrl = nextPageUrl
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
        ingredients = ingredients,
        totalTime = totalTime,
        yield = yield
    )

fun FavoritesRecipe.toEntity() = FavoritesRecipeEntity(
    id = id,
    isFavorites = isFavorites,
    titleRecipe = titleRecipe,
    sourceRecipe = sourceRecipe,
    image = image,
    urlSource = urlSource,
    calories = calories,
    ingredients = ingredients,
    totalTime = totalTime,
    yield = yield
)

fun FavoritesRecipe.toUI() = FavoritesRecipeUI(
    id = id,
    isFavorites = isFavorites,
    titleRecipe = titleRecipe,
    sourceRecipe = sourceRecipe,
    image = image,
    urlSource = urlSource,
    calories = calories,
    ingredients = ingredients,
    totalTime = totalTime,
    yield = yield
)