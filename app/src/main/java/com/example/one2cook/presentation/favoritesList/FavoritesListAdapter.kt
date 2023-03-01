package com.example.one2cook.presentation.favoritesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.one2cook.R
import com.example.one2cook.databinding.ListItemFavoritesBinding
import com.example.one2cook.presentation.model.FavoritesRecipeUI

class FavoritesListAdapter(
    private val onRecipeClicked: (FavoritesRecipeUI) -> Unit
) : RecyclerView.Adapter<FavoritesListAdapter.FavoritesHolder>() {

    private var favoritesListUI: List<FavoritesRecipeUI> = emptyList()
    fun updateDataSet(recipesList: List<FavoritesRecipeUI>) {
        favoritesListUI = recipesList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemFavoritesBinding.inflate(inflater, parent, false)
        return FavoritesHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoritesHolder, position: Int) {
        val recipe = favoritesListUI[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int = favoritesListUI.size

    inner class FavoritesHolder(
        private val binding: ListItemFavoritesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(favoritesRecipeUI: FavoritesRecipeUI) = with(binding) {
            Glide.with(root)
                .load(favoritesRecipeUI.image)
                .centerCrop()
                .placeholder(R.drawable.place_holder)
                .into(imageRecipe)

            titleRecipeTextView.text = favoritesRecipeUI.titleRecipe
            totalTimeCooking.text =
                if (favoritesRecipeUI.totalTime == 0.0) {
                    "-"
                } else {
                    favoritesRecipeUI.totalTime.toString()
                }

            root.setOnClickListener {
                this@FavoritesListAdapter.onRecipeClicked(favoritesRecipeUI)
            }
        }
    }

}