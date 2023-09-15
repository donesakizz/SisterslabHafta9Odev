package com.example.cocukeglencefirebase.view.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocukeglencefirebase.model.Category
import com.example.cocukeglencefirebase.repository.HomeRepository
import com.google.firebase.database.DatabaseReference

class CategoryViewModel : ViewModel() {

    private val homeRepository = HomeRepository()
    var categoryLiveData: MutableLiveData<List<Category>> = MutableLiveData()

    fun getCategory(refCategory: DatabaseReference) =
        homeRepository.getCategoryFromFirebase(refCategory, categoryLiveData)
}