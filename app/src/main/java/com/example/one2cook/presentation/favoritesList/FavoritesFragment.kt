package com.example.one2cook.presentation.favoritesList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.one2cook.R
import com.example.one2cook.databinding.ListFavoritesFragmentBinding
import com.example.one2cook.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoritesFragment : BaseFragment(R.layout.list_favorites_fragment) {
    override val viewModel: FavoritesViewModel by viewModels()
    private val binding: ListFavoritesFragmentBinding by viewBinding()
    private val favoritesListAdapter = FavoritesListAdapter { favoriteRecipe ->
        findNavController().navigate(
            FavoritesFragmentDirections.actionFavoritesFragmentToFavoritesDetailsFragment(
                favoriteRecipe
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        recipeGrid.layoutManager = GridLayoutManager(context, 2)
        viewModel.getFavoritesRecipes()

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.recipesList.collect{ recipesList ->
                    favoritesListAdapter.updateDataSet(recipesList)
                }
            }
        }

        recipeGrid.adapter = favoritesListAdapter

    }

}