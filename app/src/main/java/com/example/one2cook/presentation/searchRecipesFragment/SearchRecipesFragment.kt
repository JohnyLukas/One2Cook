package com.example.one2cook.presentation.searchRecipesFragment

import androidx.fragment.app.viewModels
import com.example.one2cook.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchRecipesFragment: BaseFragment() {
    override val viewModel: SearchRecipesViewModel by viewModels()
}