package com.example.one2cook.domain.useCase

import com.example.one2cook.data.network.RecipeDataSource
import com.example.one2cook.domain.model.Recipes
import com.example.one2cook.domain.useCase.base.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Named

class GetNextRecipesPageUseCase @Inject constructor(
    private val recipeDataSource: RecipeDataSource,
    @Named("IO")
    override val dispatcher: CoroutineDispatcher
) : FlowUseCase<GetNextRecipesPageUseCaseParam, Recipes> {

    override fun execute(param: GetNextRecipesPageUseCaseParam): Flow<Result<Recipes>> = flow {
        val result = recipeDataSource.nextRecipesPage(
            query = param.nameDish,
            paginationParam = param.paginationParam
        )
        emit(Result.success(result))
    }
}

data class GetNextRecipesPageUseCaseParam(
    val nameDish: String,
    val paginationParam: String?
)