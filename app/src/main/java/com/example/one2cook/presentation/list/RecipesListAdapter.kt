package com.example.one2cook.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.one2cook.databinding.ListItemRecipeBinding
import com.example.one2cook.presentation.model.HitsUI
import com.example.one2cook.presentation.model.RecipeUI

class RecipesListAdapter(
    private val onRecipeClicked: (RecipeUI) -> Unit
) : RecyclerView.Adapter<RecipesListAdapter.RecipeHolder>() {

    private var recipesListUI: List<HitsUI> = emptyList()
    fun updateDataSet(recipesList: List<HitsUI>) {
        recipesListUI = recipesList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemRecipeBinding.inflate(inflater, parent, false)
        return RecipeHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        val recipe = recipesListUI[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int = recipesListUI.size

    inner class RecipeHolder(
        private val binding: ListItemRecipeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hitsUI: HitsUI) = with(binding) {
            Glide.with(root)
                .load(hitsUI.recipeUI?.image)
                .centerCrop()
                .into(imageRecipe)

            titleRecipeTextView.text = hitsUI.recipeUI?.titleRecipe
            totalTimeCooking.text =
                if (hitsUI.recipeUI?.totalTime == 0.0) {
                    "-"
                } else {
                    hitsUI.recipeUI?.totalTime.toString()
                }

            root.setOnClickListener {
                hitsUI.recipeUI?.let { recipe ->
                    this@RecipesListAdapter.onRecipeClicked(recipe)
                }
            }
        }
    }

}