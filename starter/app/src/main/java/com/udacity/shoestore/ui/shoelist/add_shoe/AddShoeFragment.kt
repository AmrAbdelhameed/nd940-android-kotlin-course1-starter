package com.udacity.shoestore.ui.shoelist.add_shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentAddShoeBinding
import com.udacity.shoestore.ui.shoelist.HomeViewModel

class AddShoeFragment : Fragment() {
    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(HomeViewModel::class.java) }
    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentAddShoeBinding>(
            inflater,
            R.layout.fragment_add_shoe,
            container,
            false
        )
        binding.save.setOnClickListener {
            viewModel.addToList(
                binding.shoeName.text.toString(),
                binding.shoeSize.text.toString(),
                binding.shoeCompany.text.toString(),
                binding.shoeDescription.text.toString()
            )
            navController.popBackStack()
        }
        return binding.root
    }
}