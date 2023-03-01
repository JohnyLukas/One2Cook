package com.example.one2cook.domain.useCase

import com.example.one2cook.data.database.DatabaseRepository
import com.example.one2cook.data.model.entity.FavoritesRecipeEntity
import com.example.one2cook.domain.model.Recipe
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class AddRecipeToFavoritesUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository,
    @Named("IO")
    override val dispatcher: CoroutineDispatcher
) : FlowUseCase<Recipe, FavoritesRecipeEntity> {

    override fun execute(param: Recipe): Flow<Result<FavoritesRecipeEntity>> = flow {
        val listRecipes = databaseRepository.getRecipes()
        // Finding a duplicate in the database
        val checkDuplicate = listRecipes.find { it.titleRecipe == param.titleRecipe }
        if(checkDuplicate == null) {
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
                )
            )
        }

    }

}