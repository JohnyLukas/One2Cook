package com.example.one2cook.domain.useCase

import com.example.one2cook.data.database.DatabaseRepository
import com.example.one2cook.data.model.entity.FavoritesRecipeEntity
import com.example.one2cook.presentation.model.FavoritesRecipeUI
import com.example.one2cook.presentation.model.toEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Named

class DeleteRecipeFromFavoritesUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository,
    @Named("IO")
    override val dispatcher: CoroutineDispatcher
) : FlowUseCase<FavoritesRecipeUI, FavoritesRecipeEntity> {

    override fun execute(param: FavoritesRecipeUI): Flow<Result<FavoritesRecipeEntity>> = flow {
        databaseRepository.deleteRecipe(param.toEntity())
    }

}