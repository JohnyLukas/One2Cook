package com.example.one2cook.data.model

import com.example.one2cook.data.model.entity.FavoritesRecipeEntity
import com.example.one2cook.data.model.response.*
import com.example.one2cook.domain.model.*

fun RecipesResponse.toDomain() = Recipes(
        recipes = recipes?.map { it.toDomain() },
        nextPageLink = nextPageLink?.toDomain()
    )

    fun LinkResponse.toDomain() = Link(
        nextPage = nextPage?.toDomain()
    )

    fun NextResponse.toDomain() = Next(
        nextPageUrl = nextPageUrl
    )

    fun HitsResponse.toDomain() = Hits(
        recipe = recipeResponse?.toDomain()
    )

    fun RecipeResponse.toDomain() = Recipe(
        titleRecipe = titleRecipe ?: "Recipe name missing",
        image = image ?: "https://http.cat/204", //Replace on image "code 204 error"
        sourceRecipe = sourceRecipe ?: "Source is missing",
        urlSource = urlSource ?: "https://http.cat/204", //Replace on image "code 204 error",
        calories = calories ?: 0.0,
        ingredients = ingredients ?: listOf("Ingredients is unknown"),
        totalTime = totalTime ?: 0.0,
        yield = yield ?: 0
    )

fun FavoritesRecipeEntity.toDomain() = FavoritesRecipe(
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