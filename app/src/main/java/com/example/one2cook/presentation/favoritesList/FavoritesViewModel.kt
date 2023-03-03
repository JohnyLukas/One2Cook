package com.example.one2cook.presentation.favoritesList

import androidx.lifecycle.viewModelScope
import com.example.one2cook.data.network.common.NetworkException
import com.example.one2cook.domain.useCase.GetFavoritesRecipesUseCase
import com.example.one2cook.presentation.base.BaseViewModel
import com.example.one2cook.presentation.model.FavoritesRecipeUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoritesRecipesUseCase: GetFavoritesRecipesUseCase
) : BaseViewModel() {
    private val _recipesList: MutableStateFlow<List<FavoritesRecipeUI>> = MutableStateFlow(emptyList())
    val recipesList: StateFlow<List<FavoritesRecipeUI>> = _recipesList.asStateFlow()

    fun getFavoritesRecipes() {
        viewModelScope.launch {
            getFavoritesRecipesUseCase.invoke(Unit).collect { result ->
                result.onSuccess { favoritesList ->
                    _recipesList.value = favoritesList
                }.onFailure { throwable ->
                    _handleError.value = throwable.localizedMessage?.let {
                        NetworkException(
                            title = throwable.message.toString(),
                            description = throwable.toString()
                        )
                    }
                }
            }
        }
    }

}