package com.example.one2cook.presentation.search

import androidx.core.text.isDigitsOnly
import com.example.one2cook.domain.useCase.GetListRecipeUseCase
import com.example.one2cook.presentation.base.BaseViewModel
import com.example.one2cook.presentation.model.RecipesUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchRecipesViewModel @Inject constructor(
    private val getListRecipeUseCase: GetListRecipeUseCase
): BaseViewModel() {
    private val _handleErrorInput: MutableStateFlow<String?> = MutableStateFlow(null)
    val handleErrorInput: StateFlow<String?> = _handleErrorInput.asStateFlow()

    private val _namedDish: MutableStateFlow<String?> = MutableStateFlow(null)
    val namedDish: StateFlow<String?> = _namedDish.asStateFlow()

    fun checkInputError(namedDish: String?) {
        when {
            namedDish == null -> _handleErrorInput.value = "Please enter dish name"
            namedDish.isDigitsOnly() -> _handleErrorInput.value = "Please check your input"
            else -> _namedDish.value = namedDish
        }
    }

    fun clearNamedDish() {
        _namedDish.value = null
    }

}