package com.example.one2cook.presentation.detailsRecipesFragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.one2cook.R
import com.example.one2cook.databinding.RecipeDetailsFragmentBinding
import com.example.one2cook.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsRecipesFragment: BaseFragment(R.layout.recipe_details_fragment) {
    override val viewModel: DetailsRecipesViewModel by viewModels()
    private val binding: RecipeDetailsFragmentBinding by viewBinding()
    private val args: DetailsRecipesFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(root)
            .load(args.recipe.image)
            .centerCrop()
            .into(recipeImageView)

        recipeTitleTextView.text = args.recipe.titleRecipe

        cuisineTypeTextView.text = args.recipe.cuisineType.toString()

        cookingTimeTextView.text = getString(
            R.string.cooking_time,
            args.recipe.totalTime.toString()
        )

        caloriesTextView.text = getString(
            R.string.calories,
            args.recipe.calories.toString()
        )

        ingredientsTextView.text = args.recipe.ingredients.toString()

        sourceTextView.text = getString(
            R.string.source,
            args.recipe.sourceRecipe
        )

        sourceTextView.setOnClickListener {
            val browseIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://${args.recipe.urlSource}")
            )
            startActivity(browseIntent)
        }
    }

}