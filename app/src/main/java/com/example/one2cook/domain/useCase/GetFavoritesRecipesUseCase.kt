package com.example.one2cook.domain.useCase

import com.example.one2cook.data.database.DatabaseRepository
import com.example.one2cook.domain.model.toUI
import com.example.one2cook.domain.useCase.base.FlowUseCase
import com.example.one2cook.presentation.model.FavoritesRecipeUI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Named

class GetFavoritesRecipesUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository,
    @Named("IO")
    override val dispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, List<FavoritesRecipeUI>> {

    override fun execute(param: Unit): Flow<Result<List<FavoritesRecipeUI>>> = flow {
        val result = databaseRepository.getRecipes()
        emit(Result.success(result.map { it.toUI() }))
    }
}