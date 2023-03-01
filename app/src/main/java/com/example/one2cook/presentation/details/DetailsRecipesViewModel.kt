package com.example.one2cook.presentation.details

import androidx.lifecycle.viewModelScope
import com.example.one2cook.domain.useCase.AddRecipeToFavoritesUseCase
import com.example.one2cook.presentation.base.BaseViewModel
import com.example.one2cook.presentation.model.RecipeUI
import com.example.one2cook.presentation.model.toDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsRecipesViewModel @Inject constructor(
    private val addRecipeToFavoritesUseCase: AddRecipeToFavoritesUseCase
) : BaseViewModel() {
    fun addRecipeToFavorites(recipe: RecipeUI) {
        viewModelScope.launch {
            addRecipeToFavoritesUseCase(param = recipe.toDomain())
        }

    }

}