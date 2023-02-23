package com.example.one2cook.presentation.list

import androidx.lifecycle.viewModelScope
import com.example.one2cook.data.network.common.NetworkException
import com.example.one2cook.domain.model.toUI
import com.example.one2cook.domain.useCase.GetListRecipeUseCase
import com.example.one2cook.domain.useCase.GetListRecipeUseCaseParam
import com.example.one2cook.domain.useCase.GetNextRecipesPageUseCase
import com.example.one2cook.domain.useCase.GetNextRecipesPageUseCaseParam
import com.example.one2cook.presentation.base.BaseViewModel
import com.example.one2cook.presentation.model.RecipesUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesListViewModel @Inject constructor(
    private val getNextRecipesPageUseCase: GetNextRecipesPageUseCase,
    private val getListRecipeUseCase: GetListRecipeUseCase
) : BaseViewModel() {
    private val _recipesResponse: MutableStateFlow<RecipesUI?> = MutableStateFlow(null)
    val recipesResponse: StateFlow<RecipesUI?> = _recipesResponse.asStateFlow()

    fun getRecipesByNamedDish(namedDish: String) {
        viewModelScope.launch {
            getListRecipeUseCase.invoke(
                param = GetListRecipeUseCaseParam(namedDish = namedDish)
            ).collect { result ->
                result.onSuccess { recipes ->
                    _recipesResponse.value = recipes.toUI()
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

    fun getNewListRecipes(nameDish: String, cont: String) {
        viewModelScope.launch {
            getNextRecipesPageUseCase.invoke(
                param = GetNextRecipesPageUseCaseParam(nameDish = nameDish, cont = cont)
            ).collect { result ->
                result.onSuccess { recipes ->

                }.onFailure { throwable ->

                }
            }
        }
    }
}