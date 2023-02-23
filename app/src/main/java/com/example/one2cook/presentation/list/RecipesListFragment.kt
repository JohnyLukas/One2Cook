package com.example.one2cook.presentation.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.one2cook.R
import com.example.one2cook.databinding.ListRecipesFragmentBinding
import com.example.one2cook.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipesListFragment : BaseFragment(R.layout.list_recipes_fragment) {
    override val viewModel: RecipesListViewModel by viewModels()
    private val binding: ListRecipesFragmentBinding by viewBinding()
    private val args: RecipesListFragmentArgs by navArgs()
    private val recipesListAdapter = RecipesListAdapter { recipe ->
        findNavController().navigate(
            RecipesListFragmentDirections
                .actionListRecipesToDetailsRecipes(
                    recipe
                )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recipeGrid.layoutManager = GridLayoutManager(context, 2)
        viewModel.getRecipesByNamedDish(args.dishName)
        args.recipesList.recipes?.let { recipesList ->
            recipesListAdapter.updateDataSet(recipesList)
        }
        binding.recipeGrid.adapter = recipesListAdapter

        binding.recipeGrid.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(1)) {
                    Toast.makeText(context, "Last item", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

}