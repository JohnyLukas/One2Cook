package com.example.one2cook.presentation.favoritesDetails

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.one2cook.R
import com.example.one2cook.databinding.RecipeDetailsFragmentFavoritesBinding
import com.example.one2cook.presentation.base.BaseFragment
import com.example.one2cook.presentation.details.DetailsRecipesFragmentDirections
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesDetailsFragment : BaseFragment(R.layout.recipe_details_fragment_favorites) {
    override val viewModel: FavoritesDetailsViewModel by viewModels()
    private val binding: RecipeDetailsFragmentFavoritesBinding by viewBinding()
    private val args: FavoritesDetailsFragmentArgs by navArgs()
    private val customTabsIntent = CustomTabsIntent.Builder().build()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){
        super.onViewCreated(view, savedInstanceState)

        Glide.with(root)
            .load(args.recipe.image)
            .centerCrop()
            .placeholder(R.drawable.place_holder)
            .into(recipeImageView)

        recipeTitleTextView.text = args.recipe.titleRecipe

        cookingTimeTextView.text = getString(
            R.string.cooking_time,
            args.recipe.totalTime.toString()
        )

        caloriesTextView.text = getString(
            R.string.calories,
            args.recipe.calories.toString().substringBefore(".")
        )

        yieldTextView.text = getString(
            R.string.yield,
            args.recipe.yield.toString()
        )

        args.recipe.ingredients.forEachIndexed { index, ingredient ->
            val chip = Chip(context)
            chip.text = ingredient
            chip.id = index
            chip.setOnClickListener {
                findNavController().navigate(
                    DetailsRecipesFragmentDirections
                        .actionDetailsRecipesFragmentToListRecipesFragment(
                            chip.text.toString()
                        )
                )
            }
            ingredientsList.addView(chip)

        }

        sourceTextView.text = getString(
            R.string.source,
            args.recipe.sourceRecipe
        )

        sourceTextView.setOnClickListener {
            context?.let { context ->
                customTabsIntent.launchUrl(context, Uri.parse(args.recipe.urlSource))
            }
        }

        addToFavorites.isChecked

        addToFavorites.setOnCheckedChangeListener { button, isChecked ->
            if (!isChecked && button.isPressed) {
                viewModel.deleteRecipe(args.recipe)
            }
        }
    }

}