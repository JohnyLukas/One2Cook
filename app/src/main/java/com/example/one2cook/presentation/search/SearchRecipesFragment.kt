package com.example.one2cook.presentation.search

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.one2cook.R
import com.example.one2cook.databinding.SearchRecipesFragmentBinding
import com.example.one2cook.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchRecipesFragment: BaseFragment(R.layout.search_recipes_fragment) {
    override val viewModel: SearchRecipesViewModel by viewModels()
    private val binding: SearchRecipesFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.handleErrorInput.collect { exception ->
                    exception?.let {
                        textInputNamedDishEditText.error = it
                    }
                }
            }
        }

        // Разобраться с 2 подписками, пробовать пихнуть в одну

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.namedDish.collect { namedDish ->
                    namedDish?.let {
                        findNavController().navigate(
                            SearchRecipesFragmentDirections.actionSearchFragmentToListFragment(
                                namedDish
                            )
                        )
                    }
                    viewModel.clearNamedDish()
                    textInputNamedDishEditText.text?.clear()
                }
            }
        }

        textInputNamedDishEditText.doAfterTextChanged {
            textInputNamedDishEditText.error = null
        }

        searchButton.setOnClickListener {
            viewModel.checkInputError(textInputNamedDishEditText.text.toString())
        }
    }

}