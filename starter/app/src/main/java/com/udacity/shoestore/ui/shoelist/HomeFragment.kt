package com.udacity.shoestore.ui.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentHomeBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.shoe_item.view.*

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(HomeViewModel::class.java) }
    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoes ->
            for (i in 0 until shoes.size) {
                addNewShoe()
                bindShoeData(i, shoes[i])
            }
        })
        binding.add.setOnClickListener {
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToAddShoeFragment())
        }
        return binding.root
    }

    private fun addNewShoe() {
        val view = LayoutInflater.from(context).inflate(R.layout.shoe_item, binding.shoesList, false)
        binding.shoesList.addView(view, binding.shoesList.childCount)
    }

    private fun bindShoeData(index: Int, shoe: Shoe) {
        val child = binding.shoesList.getChildAt(index)
        child.shoe_name.text = "${getString(R.string.shoe_name)}: ${shoe.name}"
        child.shoe_size.text = "${getString(R.string.shoe_size)}: ${shoe.size}"
        child.shoe_company.text = "${getString(R.string.shoe_company)}: ${shoe.company}"
        child.shoe_description.text = "${getString(R.string.shoe_description)}: ${shoe.description}"
    }
}