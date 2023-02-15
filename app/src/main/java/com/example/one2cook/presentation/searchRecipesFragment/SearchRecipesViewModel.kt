package com.example.one2cook.presentation.searchRecipesFragment

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.viewModelScope
import com.example.one2cook.data.net.common.NetworkException
import com.example.one2cook.domain.model.toUI
import com.example.one2cook.domain.useCase.GetListRecipeUseCase
import com.example.one2cook.domain.useCase.GetListRecipeUseCaseParam
import com.example.one2cook.presentation.base.BaseViewModel
import com.example.one2cook.presentation.model.RecipesUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchRecipesViewModel @Inject constructor(
    private val getListRecipeUseCase: GetListRecipeUseCase
): BaseViewModel() {
    private val _handleErrorInput: MutableStateFlow<String?> = MutableStateFlow(null)
    val handleErrorInput: StateFlow<String?> = _handleErrorInput.asStateFlow()

    private val _recipesResponse: MutableStateFlow<RecipesUI?> = MutableStateFlow(null)

    fun checkInputError(namedDish: String?) {
        when {
            namedDish == null -> _handleErrorInput.value = "Please enter dish name"
            namedDish.isDigitsOnly() -> _handleErrorInput.value = "Please check your input"
            else -> getRecipesByNamedDish(namedDish)
        }
    }

    private fun getRecipesByNamedDish(namedDish: String) {
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

}