package com.example.one2cook.domain.useCase

import com.example.one2cook.data.network.SearchRecipeRepository
import com.example.one2cook.domain.model.Recipes
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Named

class GetNextRecipesPage @Inject constructor(
    private val searchRecipeRepository: SearchRecipeRepository,
    @Named("IO")
    override val dispatcher: CoroutineDispatcher
) : FlowUseCase<GetNextRecipesPageParam, Recipes> {

    override fun execute(param: GetNextRecipesPageParam): Flow<Result<Recipes>> = flow {
        val result = searchRecipeRepository.nextRecipesPage(
            query = param.nameDish,
            cont = param.cont
        )
        emit(Result.success(result))
    }
}

data class GetNextRecipesPageParam(
    val nameDish: String,
    val cont: String
)