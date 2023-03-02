package com.example.one2cook.domain.useCase

import com.example.one2cook.data.database.DatabaseRepository
import com.example.one2cook.domain.useCase.base.SuspendUseCase
import com.example.one2cook.presentation.model.FavoritesRecipeUI
import com.example.one2cook.presentation.model.toEntity
import javax.inject.Inject

class DeleteRecipeFromFavoritesUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) : SuspendUseCase<FavoritesRecipeUI, Unit> {

    override suspend fun execute(param: FavoritesRecipeUI) {
        databaseRepository.deleteRecipe(param.toEntity())
    }

}