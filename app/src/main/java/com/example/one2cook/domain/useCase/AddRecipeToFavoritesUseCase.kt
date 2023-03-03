package com.example.one2cook.domain.useCase

import com.example.one2cook.data.database.DatabaseRepository
import com.example.one2cook.data.model.entity.FavoritesRecipeEntity
import com.example.one2cook.domain.model.Recipe
import com.example.one2cook.domain.useCase.base.SuspendUseCase
import java.util.*
import javax.inject.Inject

class AddRecipeToFavoritesUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) : SuspendUseCase<Recipe, Unit> {

    override suspend fun execute(param: Recipe) {
        val favoritesList = databaseRepository.getRecipes()
        // Finding a duplicate in the database
        val checkDuplicate = favoritesList.find { it.titleRecipe == param.titleRecipe }
        if (checkDuplicate == null) {
            databaseRepository.addRecipe(
                FavoritesRecipeEntity(
                    id = UUID.randomUUID(),
                    isFavorites = true,
                    titleRecipe = param.titleRecipe,
                    image = param.image,
                    sourceRecipe = param.sourceRecipe,
                    urlSource = param.urlSource,
                    calories = param.calories,
                    ingredients = param.ingredients,
                    totalTime = param.totalTime,
                    yield = param.yield
            ))
        }
    }

}