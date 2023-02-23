package com.example.one2cook.presentation.list

import androidx.lifecycle.viewModelScope
import com.example.one2cook.domain.useCase.GetNextRecipesPage
import com.example.one2cook.domain.useCase.GetNextRecipesPageParam
import com.example.one2cook.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesListViewModel @Inject constructor(
    private val getNextRecipesPage: GetNextRecipesPage
) : BaseViewModel() {
    fun getNewListRecipes(nameDish: String, cont: String) {
        viewModelScope.launch {
            getNextRecipesPage.invoke(
                param = GetNextRecipesPageParam(nameDish = nameDish, cont = cont)
            ).collect { result ->
                result.onSuccess { recipes ->

                }
            }
        }
    }
}