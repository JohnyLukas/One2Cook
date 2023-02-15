package com.example.one2cook.presentation.listRecipesFragment

import androidx.fragment.app.viewModels
import com.example.one2cook.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListRecipesFragment : BaseFragment() {
    override val viewModel: ListRecipesViewModel by viewModels()
}