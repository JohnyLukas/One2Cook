package com.example.one2cook.presentation.favoritesDetails

import androidx.lifecycle.viewModelScope
import com.example.one2cook.domain.useCase.DeleteRecipeFromFavoritesUseCase
import com.example.one2cook.presentation.base.BaseViewModel
import com.example.one2cook.presentation.model.FavoritesRecipeUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesDetailsViewModel @Inject constructor(
    private val deleteRecipeFromFavoritesUseCase: DeleteRecipeFromFavoritesUseCase
) : BaseViewModel() {
    fun deleteRecipe(favoritesRecipeUI: FavoritesRecipeUI) {
        viewModelScope.launch {
            deleteRecipeFromFavoritesUseCase.invoke(
                param = favoritesRecipeUI
            )
        }
    }

}