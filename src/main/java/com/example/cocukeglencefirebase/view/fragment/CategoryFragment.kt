package com.example.cocukeglencefirebase.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocukeglencefirebase.R
import com.example.cocukeglencefirebase.adapter.CategoryAdapter
import com.example.cocukeglencefirebase.databinding.FragmentCategoryBinding
import com.example.cocukeglencefirebase.model.Category
import com.example.cocukeglencefirebase.view.ViewModel.CategoryViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class CategoryFragment : Fragment(R.layout.fragment_category) {
    private lateinit var binding: FragmentCategoryBinding
    private val viewModel: CategoryViewModel by viewModels()
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var refCategory: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoryBinding.bind(view)

        binding.toolbarCategory.title = "Category"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarCategory)

        val database = FirebaseDatabase.getInstance()
        refCategory = database.getReference("category")

        binding.categoryRv.setHasFixedSize(true)
        binding.categoryRv.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getCategory(refCategory)
        observeLiveData()
    }

    private fun navigateToLis(category: Category) {
        val action = CategoryFragmentDirections.navigateToList(category.categoryName)
        findNavController().navigate(action)
    }

    private fun observeLiveData() {
        viewModel.categoryLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                categoryAdapter = CategoryAdapter(it, ::navigateToLis)
                binding.categoryRv.adapter = categoryAdapter
            } else {
                Snackbar.make(requireView(), "Liste boş!!", Snackbar.LENGTH_SHORT).show()
            }
        }
    }




}