package com.example.one2cook.presentation.detailsRecipesFragment

import androidx.fragment.app.viewModels
import com.example.one2cook.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsRecipesFragment: BaseFragment() {
    override val viewModel: DetailsRecipesViewModel by viewModels()
}