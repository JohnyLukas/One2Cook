package com.example.one2cook.presentation.list

import androidx.lifecycle.viewModelScope
import com.example.one2cook.data.network.common.NetworkException
import com.example.one2cook.domain.model.toUI
import com.example.one2cook.domain.useCase.GetListRecipeUseCase
import com.example.one2cook.domain.useCase.GetListRecipeUseCaseParam
import com.example.one2cook.domain.useCase.GetNextRecipesPageUseCase
import com.example.one2cook.domain.useCase.GetNextRecipesPageUseCaseParam
import com.example.one2cook.presentation.base.BaseViewModel
import com.example.one2cook.presentation.model.HitsUI
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

    private val _recipesList: MutableStateFlow<List<HitsUI>?> = MutableStateFlow(null)
    val recipesList: StateFlow<List<HitsUI>?> = _recipesList.asStateFlow()
    private var nextPageUrl: String? = null

    fun getRecipesByNamedDish(namedDish: String) {
        viewModelScope.launch {
            getListRecipeUseCase.invoke(
                param = GetListRecipeUseCaseParam(namedDish = namedDish)
            ).collect { result ->
                result.onSuccess { recipes ->
                    nextPageUrl = recipes.toUI().nextPageLink?.nextPage?.nextPageUrl
                    _recipesList.value = recipes.recipes?.map { it.toUI() }
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

    fun getNewListRecipes(nameDish: String) {
        if (nextPageUrl == null) {
            _handleError.value = NetworkException(
                title = "Error",
                description = "There are no more recipes"
            )
        } else {
            val startIndex = nextPageUrl?.indexOf("_cont")
            val paginationParam = startIndex?.let {
                nextPageUrl
                    ?.substring(it)
                    ?.substring(6)
                    ?.substringBefore('&')
            }

            viewModelScope.launch {
                getNextRecipesPageUseCase.invoke(
                    param = GetNextRecipesPageUseCaseParam(
                        nameDish = nameDish,
                        paginationParam = paginationParam
                    )
                ).collect { result ->
                    result.onSuccess { recipes ->
                        nextPageUrl = recipes.toUI().nextPageLink?.nextPage?.nextPageUrl
                        _recipesList.value = recipes.recipes?.map { it.toUI() }
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

}