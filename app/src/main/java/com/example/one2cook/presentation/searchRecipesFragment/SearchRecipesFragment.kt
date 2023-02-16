package com.example.one2cook.presentation.searchRecipesFragment

import androidx.fragment.app.viewModels
import com.example.one2cook.R
import com.example.one2cook.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchRecipesFragment: BaseFragment(R.layout.search_recipes_fragment) {
    override val viewModel: SearchRecipesViewModel by viewModels()
}