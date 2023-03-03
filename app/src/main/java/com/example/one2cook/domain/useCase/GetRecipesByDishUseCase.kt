package com.example.one2cook.domain.useCase

import com.example.one2cook.data.network.RecipeDataSource
import com.example.one2cook.domain.model.Recipes
import com.example.one2cook.domain.useCase.base.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Named

class GetRecipesByDishUseCase @Inject constructor(
    private val recipeDataSource: RecipeDataSource,
    @Named("IO")
    override val dispatcher: CoroutineDispatcher
) : FlowUseCase<GetListRecipeUseCaseParam, Recipes> {

    override fun execute(param: GetListRecipeUseCaseParam): Flow<Result<Recipes>> = flow {
        val responseRecipes = recipeDataSource.searchRecipe(param.namedDish)
        emit(Result.success(responseRecipes))
    }
}

data class GetListRecipeUseCaseParam(
    val namedDish: String
)